package com.geekarms.controller;

import com.geekarms.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kaywer on 2017/1/13.
 */
@RestController
@RequestMapping(value = "/api/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping
    public Object redisTest(@RequestParam String operate, @RequestParam String field, @RequestParam String value){
        try {
            return redisService.redisTest(operate, field, value);
        }catch (Exception e){
            e.printStackTrace();
            return e;
        }
    }
}
