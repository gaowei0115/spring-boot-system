// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis.config;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.mmc.boot.system.redis.config.serializer.RedisObjectSerializer;

/**
 * ClassName: RedisCacheConfig<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
//@Configuration
//@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

	// logger
	private static final Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);
	
	/**
	 * Description：缓存管理器<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * 
	 * @param template
	 * @return
	 */
	//@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> template) {
		CacheManager cacheManager = new RedisCacheManager(template);
		return cacheManager;
	}

	//@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		redisTemplate.setHashKeySerializer(redisSerializer);
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		return redisTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.cache.annotation.CachingConfigurerSupport#
	 * keyGenerator()
	 */
	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {

			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				logger.info("keyGenerator=" + sb.toString());
				return sb.toString();
			}
		};
	}

}
