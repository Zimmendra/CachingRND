package com.testbed.testbed.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManagerCustomizer<ConcurrentMapCacheManager> customizer() {
        return new ConcurrentCustomizer();
    }

    static class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false); // Prevent storing null values
            cacheManager.setStoreByValue(true); // Store cache entries by value, not by reference
            //storing the actual value will result in performance issues
            //but when you want to ensure that the data in the cache doesn't get accidentally changed by external code, providing a clear separation between the cache and the original object.
        }
    }
}
