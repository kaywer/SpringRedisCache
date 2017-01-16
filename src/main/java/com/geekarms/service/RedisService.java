package com.geekarms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by kaywer on 2017/1/13.
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;

    public Object redisTest(final String operate, final String field, final String value){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        if ("SET".equalsIgnoreCase(operate)){
            operations.set(field, value);
            return "SET " + field + " " + value +" TRUE!";
        }else if ("GET".equalsIgnoreCase(operate)){
            return operations.get(field);
        }
        return "ERROR OPERATE";
    }

}
