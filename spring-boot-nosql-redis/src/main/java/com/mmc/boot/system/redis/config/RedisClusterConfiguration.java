package com.mmc.boot.system.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @packageName：com.mmc.boot.system.redis.config
 * @desrciption: JRedis连接池配置 集群
 * @author: gaowei
 * @date： 2018-12-26 16:12
 * @history: (version) author date desc
 */
@Configuration
public class RedisClusterConfiguration {


    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisCluster jedisCluster() {
        List<String> nodesList = redisProperties.getCluster().getNodes();
        Set<HostAndPort> set = new HashSet<>();
        if (nodesList != null && nodesList.size() > 0) {
            HostAndPort hap = null;
            for (String node : nodesList) {
                String[] haps = node.split(":");
                hap = new HostAndPort(haps[0], Integer.parseInt(haps[1]));
                set.add(hap);
            }
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
        jedisPoolConfig.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
        jedisPoolConfig.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getJedis().getPool().getMaxWait().toMillis());
        return new JedisCluster(set, (int)redisProperties.getTimeout().toMillis(), jedisPoolConfig);
    }
}
