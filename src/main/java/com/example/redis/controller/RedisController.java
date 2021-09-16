package com.example.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private RedisTemplate redisTemplate;

    public RedisController(RedisTemplate redisTemplate){
        this.redisTemplate =redisTemplate;
    }

    @GetMapping("/set/{token}")
    public String setRedis(@PathVariable String token) {

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("token", token);

        return valueOperations.get("token");
    }

    @GetMapping("/get/{token}")
    public String getRedis(@PathVariable String token) {

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return "token == " + valueOperations.get(token);
    }

}
