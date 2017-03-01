package com.architecture.em.utils.lock;

import com.architecture.em.utils.cache.RedisOperationUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * redis锁
 * 实现遗留问题：
 * 1. 一般情况下，lock状态只能被锁定者释放，即{@link #unlock()}只能被锁定者调用，但目前没做限制
 * </pre>
 * @see RedisLockFactory
 */
public class RedisLock {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);

    private final String lockName;

    private final long tryLockInterval;

    RedisLock(final String lockName, final long tryLockInterval) {
        if (StringUtils.isBlank(lockName)) {
            throw new IllegalArgumentException("lock name can't be blank.");
        }
        this.lockName = lockName;
        this.tryLockInterval = tryLockInterval;
    }


    /**
     * 非同步方法，锁定失败，立刻返回
     *
     * @param lockTimeout 锁定时间，建议大于0
     * @param unit        锁定时间单位
     * @return 锁定成功，返回true，否则false
     */
    public boolean lock(final long lockTimeout, final TimeUnit unit) {
        final boolean isLocked = RedisOperationUtil.setIfAbsent(this.lockName, this.lockName);

        if (isLocked) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("{} is locked for {} ms.", this.lockName, unit.toMillis(lockTimeout));
            }

            RedisOperationUtil.expire(this.lockName, lockTimeout, unit);
        }

        return isLocked;
    }

    /**
     * 同步锁定方法，tryLockTime时间内锁定成功后立即返回
     *
     * @param tryLockTimeout 尝试锁定超时时间，0则不等待，直接返回，大于0则为等待时间
     * @param lockTimeout    锁定时间，建议大于0
     * @param unit           尝试锁定时间和锁定时间单位
     * @return 锁定成功，返回true，否则，返回false
     */
    public boolean syncLock(final long tryLockTimeout, final long lockTimeout, final TimeUnit unit) {
        boolean isLocked = lock(lockTimeout, unit);

        if (isLocked || 0L >= tryLockTimeout) {
            return isLocked;
        }

        final long startTimestamp = System.currentTimeMillis();
        final long diff = unit.toMillis(lockTimeout);

        while (diff >= (System.currentTimeMillis() - startTimestamp)) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("{} retry lock.", this.lockName);
            }

            isLocked = lock(lockTimeout, unit);

            if (isLocked) {
                break;
            }

            try {
                Thread.sleep(this.tryLockInterval);
            } catch (InterruptedException e) {
                // ignore
            }
        }

        return isLocked;
    }

    /**
     * 手动释放锁，否则等到锁定时间后自动释放
     */
    public void unlock() {
        RedisOperationUtil.deleteCache(this.lockName);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("{} is unlocked.", this.lockName);
        }
    }
}

