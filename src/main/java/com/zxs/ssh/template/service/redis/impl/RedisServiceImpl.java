package com.zxs.ssh.template.service.redis.impl;

import com.zxs.ssh.template.service.redis.api.IRedisService;
import com.zxs.ssh.template.service.util.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project Name:spring-redis
 * File Name:RedisServiceImpl
 * Package Name:com.zxs.ssh.template.service.redis.impl
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("redisService")
public class RedisServiceImpl implements IRedisService{
    @Resource(name = "redisUtil")
    private RedisUtil redisUtil;
    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public void testString() throws Exception{
        // stringRedisTemplate的操作
        // String读写
        redisTemplate.delete("myStr");
        redisTemplate.opsForValue().set("myStr", "skyLine");
        System.out.println(redisTemplate.opsForValue().get("myStr"));
        System.out.println("---------------");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void testList() throws Exception{
        // List读写
        redisTemplate.delete("myList");
        redisTemplate.opsForList().rightPush("myList", "T");
        redisTemplate.opsForList().rightPush("myList", "L");
        redisTemplate.opsForList().leftPush("myList", "A");
        List<String> listCache = redisTemplate.opsForList().range("myList", 0, -1);
        for (String s : listCache) {
            System.out.println(s);
        }
        System.out.println("---------------");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void testSet() throws Exception {
        // Set读写
        redisTemplate.delete("mySet");
        redisTemplate.opsForSet().add("mySet", "A");
        redisTemplate.opsForSet().add("mySet", "B");
        redisTemplate.opsForSet().add("mySet", "C");
        redisTemplate.opsForSet().add("mySet", "C");
        redisTemplate.opsForSet().add("mySet", "D");
        Set<String> setCache = redisTemplate.opsForSet().members("mySet");
        for (String s : setCache) {
            System.out.println(s);
        }
        System.out.println("---------------");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void testHash() throws Exception {
        // Hash读写
        redisTemplate.delete("myHash");
        redisTemplate.opsForHash().put("myHash", "BJ", "北京");
        redisTemplate.opsForHash().put("myHash", "SH", "上海");
        redisTemplate.opsForHash().put("myHash", "HN", "河南");
        Map<String, String> hashCache = redisTemplate.opsForHash().entries("myHash");
        for (Map.Entry entry : hashCache.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("---------------");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void testZSet() throws Exception {
        // Set读写
        redisTemplate.delete("myZSet");
        redisTemplate.opsForZSet().add("myZSet", "A",2);
        redisTemplate.opsForZSet().add("myZSet", "B",2);
        redisTemplate.opsForZSet().add("myZSet", "C",3);
        redisTemplate.opsForZSet().add("myZSet", "C",1);
        redisTemplate.opsForZSet().add("myZSet", "D",11);
        Set<String> setCache = redisTemplate.opsForZSet().range("myZSet",0,-1);
        for (String s : setCache) {
            System.out.println(s);
        }
        System.out.println("---------------");
    }
}
