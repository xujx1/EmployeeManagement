package com.architecture.em.utils.lock;

public class RedisLockFactory {

    private long tryLockInterval = 500;

    public RedisLock getLock(final String lockName) {
        return new RedisLock(lockName, this.tryLockInterval);
    }

    public void setTryLockInterval(long tryLockInterval) {
        this.tryLockInterval = tryLockInterval;
    }
}
