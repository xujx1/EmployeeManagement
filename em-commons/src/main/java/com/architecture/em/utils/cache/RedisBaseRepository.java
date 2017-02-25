package com.architecture.em.utils.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisBaseRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveCache(String key, Object value, int time, TimeUnit timeUnit) {
        this.deleteCache(key);
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    public Object findCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteCache(String key) {
        redisTemplate.delete(key);
    }

    public void updateCache(String key, Object value, int time, TimeUnit timeUnit) {
        this.deleteCache(key);
        this.saveCache(key, value, time, timeUnit);
    }
}
