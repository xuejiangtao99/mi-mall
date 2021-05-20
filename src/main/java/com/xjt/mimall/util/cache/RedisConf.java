package com.xjt.mimall.util.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConf {



    private String host;//reidisIp
    private int port;//端口号
    private String password;
    private int timeout; //等待时间
    private int maxIdleTime;//最大等待时间
    private int maxPoolSize;//最大连接个数
    private int maxPoolWait;//最大等待时间
}
