package com.zxs.ssh.template.service.redis.api;

/**
 * Project Name:spring-redis
 * File Name:IRedisService
 * Package Name:com.zxs.ssh.template.service.redis.api
 * Date:2019/2/19
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IRedisService {
    void testString() throws Exception;
    void testList() throws Exception;
    void testSet() throws Exception;
    void testHash() throws Exception;
    void testZSet() throws Exception;
}
