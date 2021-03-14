package com.unsplash.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class CacheEvictConfig {

    // 5 hours gap
    private static final int EVICTION_TIME = 5 * 60 * 60 * 1000;

    @Autowired
    private CacheManager manager;


    @Scheduled(fixedRate = EVICTION_TIME)
    public void evictAll() {
        manager.getCacheNames().stream().forEach(
                cacheName -> manager.getCache(cacheName).clear()
        );
    }
}
