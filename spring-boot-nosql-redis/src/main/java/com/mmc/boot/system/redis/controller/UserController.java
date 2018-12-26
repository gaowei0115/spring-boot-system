package com.mmc.boot.system.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packageName：com.mmc.boot.system.redis.controller
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-26 15:40
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/u")
public class UserController {

    private static final String UserTotal_key = "userTotal_key";

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("userTotal")
    public String userTotal() {
        Object obj = redisTemplate.opsForValue().get(UserTotal_key);
        System.out.println(obj);
        int count = Integer.parseInt(obj + "");
        count++;
        redisTemplate.opsForValue().set(UserTotal_key, count);

        int result = (int) redisTemplate.opsForValue().get(UserTotal_key);
        return "目前在线人数 " + result + " 人";
    }
}
