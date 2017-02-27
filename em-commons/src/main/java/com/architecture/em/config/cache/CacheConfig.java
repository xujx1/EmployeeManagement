package com.architecture.em.config.cache;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * ehcache直接在jvm虚拟机中缓存，速度快，效率高；
 * 但是缓存共享麻烦，集群分布式应用不方便。
 * 可存放静态数据，比如历史订单信息
 */
@Configuration
@EnableCaching
public class CacheConfig {

    public static final int DEFAULT_MAXSIZE = 50000;
    public static final int DEFAULT_TTL = 10;


    public enum Caches{
        messageContent(8640000),
        getSomeData,
        qiniuUpToken(1800, 1),

        getCommonAds(60),
        getAndAssembleAreaSpecificAds(60);

        Caches() {
        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        private int maxSize=DEFAULT_MAXSIZE;    //最大數量
        private int ttl=DEFAULT_TTL;        //过期时间（秒）

        public int getMaxSize() {
            return maxSize;
        }
        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }
        public int getTtl() {
            return ttl;
        }
        public void setTtl(int ttl) {
            this.ttl = ttl;
        }
    }

    /**
     * 创建基于guava的Cache Manager
     * @return
     */
    @Bean
    @Primary
    public CacheManager guavaCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
        ArrayList<GuavaCache> caches = new ArrayList<>();
        for(Caches c : Caches.values()){
            caches.add(new GuavaCache(c.name(), CacheBuilder.newBuilder().recordStats().expireAfterWrite(c.getTtl(), TimeUnit.SECONDS).maximumSize(c.getMaxSize()).build()));
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
