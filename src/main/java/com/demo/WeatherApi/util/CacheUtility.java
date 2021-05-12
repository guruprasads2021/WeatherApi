package com.demo.WeatherApi.util;

import java.util.Date;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheUtility {

	public static final String CITY_WEATHER = "cityWeather";
   
	@Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(CITY_WEATHER);
        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {CITY_WEATHER})
    @Scheduled(fixedDelay = 120 * 60 * 1000 ,  initialDelay = 500)
    public void reportCacheEvict() {
        System.out.println("Flushing Cache " +new Date());
    }
}
