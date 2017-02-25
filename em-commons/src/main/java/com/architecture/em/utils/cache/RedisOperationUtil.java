package com.architecture.em.utils.cache;

import com.architecture.em.utils.beans.BeanContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by xujinxin on 2017/2/25.
 */
public class RedisOperationUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisOperationUtil.class);

    private static RedisBaseRepository redisBaseRepository = null;

    private RedisOperationUtil() {

    }

    static {
        Object obj = BeanContext.getContext().getBean(RedisBaseRepository.class);
        if (obj != null) {
            redisBaseRepository = (RedisBaseRepository) obj;
        }
        if (null == redisBaseRepository) {
            LOGGER.error("redisBaseRepository 实例化失败");
            throw new RuntimeException("实例化bean redisBaseRepository失败");
        }
    }

    public static void saveCache(String key, Object value, int time, TimeUnit timeUnit) {
        redisBaseRepository.saveCache(key, value, time, timeUnit);
    }

    public static Object findCache(String key) {
        return redisBaseRepository.findCache(key);
    }

    public static void deleteCache(String key) {
        redisBaseRepository.deleteCache(key);
    }

    public static void updateCache(String key, Object value, int time, TimeUnit timeUnit) {
        redisBaseRepository.updateCache(key, value, time, timeUnit);
    }

}
