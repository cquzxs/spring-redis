package com.zxs.ssh.template.controller;

import com.zxs.ssh.template.model.response.ResponseResult;
import com.zxs.ssh.template.service.redis.api.IRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Project Name:spring-redis
 * File Name:RedisController
 * Package Name:com.zxs.ssh.template.controller
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@RestController("redisController")
public class RedisController {
    @Resource(name = "redisService")
    private IRedisService redisService;

    @GetMapping("redis/testString")
    public Object testString(){
        try{
            this.redisService.testString();
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, new HashMap<>(), "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("redis/testList")
    public Object testList(){
        try{
            this.redisService.testList();
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, new HashMap<>(), "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("redis/testSet")
    public Object testSet(){
        try{
            this.redisService.testSet();
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, new HashMap<>(), "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("redis/testHash")
    public Object testHash(){
        try{
            this.redisService.testHash();
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, new HashMap<>(), "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
    @GetMapping("redis/testZSet")
    public Object testZSet(){
        try{
            this.redisService.testZSet();
            return new ResponseResult(0, ResponseResult.ResponseState.SUCCESS, new HashMap<>(), "");
        }catch (Exception e){
            return new ResponseResult(1, ResponseResult.ResponseState.EXCEPTION, new HashMap<>(), e.getMessage());
        }
    }
}
