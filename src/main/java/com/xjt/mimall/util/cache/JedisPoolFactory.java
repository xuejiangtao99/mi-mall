package com.xjt.mimall.util.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class JedisPoolFactory {

    @Autowired
    private RedisConf redisConf;

    @Bean
    public JedisPool jedisPool(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(redisConf.getMaxPoolWait()*1000);//最大等待时间
        jedisPoolConfig.setMaxTotal(redisConf.getMaxPoolSize());
        jedisPoolConfig.setMaxIdle(redisConf.getMaxIdleTime());

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,redisConf.getHost(),redisConf.getPort(),redisConf.getTimeout()*1000,
                redisConf.getPassword()
        );

        return jedisPool;
    }
}
