// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.mmc.boot.system.redis.config.serializer.RedisObjectSerializer;

import redis.clients.jedis.JedisPoolConfig;

/** 
 * ClassName: RedisConfig<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {

	// logger
	private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
	
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPoolConfig(jedisPoolConfig());
		logger.info("jedis connection factory init success...");
		return factory;
	}
	
	@Bean
	public RedisTemplate<?, ?> getRedisTemplate() {
		RedisTemplate<?, ?> template = new StringRedisTemplate(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}
	
}
