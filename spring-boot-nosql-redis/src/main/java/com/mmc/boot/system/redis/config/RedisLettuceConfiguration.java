package com.mmc.boot.system.redis.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @packageName：com.mmc.boot.system.redis.config
 * @desrciption: redis lettuce连接池方式配置
 * @author: gaowei
 * @date： 2018-12-26 10:57
 * @history: (version) author date desc
 */
//@Configuration
public class RedisLettuceConfiguration {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(RedisLettuceConfiguration.class);


    @Autowired
    private Environment environment;


    /**
     * redis 连接工厂
     * @return
     */
    @Bean
    public RedisConnectionFactory luttuceConnectionFactory() {
        Map<String, Object> source = new HashMap<>();
        source.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
        source.put("spring.redis.cluster.max-redirects", environment.getProperty("spring.redis.cluster.max-redirects"));

        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
        return new LettuceConnectionFactory(redisClusterConfiguration);
    }

    /**
     * redis操作
     * @return
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
