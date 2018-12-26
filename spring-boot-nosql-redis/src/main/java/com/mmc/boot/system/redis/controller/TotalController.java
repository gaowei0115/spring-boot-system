package com.mmc.boot.system.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

/**
 * @packageName：com.mmc.boot.system.redis.controller
 * @desrciption:
 * @author: gaowei
 * @date： 2018-12-26 16:31
 * @history: (version) author date desc
 */
@RestController
@RequestMapping("/t")
public class TotalController {

    private static final String TOTAL_KEY = "TOTAL_KEY";

    @Autowired
    private JedisCluster jedisCluster;

    @RequestMapping("total")
    public String totalInfo() {
        String result = jedisCluster.get(TOTAL_KEY);
        if (StringUtils.isEmpty(result)) {
            jedisCluster.set(TOTAL_KEY, 0 + "");
        }
        result = jedisCluster.get(TOTAL_KEY);
        int count = Integer.parseInt(result);
        count++;
        jedisCluster.set(TOTAL_KEY, count + "");

        String r = jedisCluster.get(TOTAL_KEY);
        return "当前在线人数 " + r + " 人";
    }
}
