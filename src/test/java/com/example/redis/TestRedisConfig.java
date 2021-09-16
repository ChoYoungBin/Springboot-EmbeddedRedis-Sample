package com.example.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class TestRedisConfig {

    private RedisServer redisServer;

    @Value("${spring.redis.port}")
    int redisPort;

     public TestRedisConfig(){
         redisServer = new RedisServer(redisPort);

     }

     @PostConstruct
    public void startRedis(){
         redisServer.start();
     }

     @PreDestroy
    public void stopRedis(){
         redisServer.stop();
     }

}
