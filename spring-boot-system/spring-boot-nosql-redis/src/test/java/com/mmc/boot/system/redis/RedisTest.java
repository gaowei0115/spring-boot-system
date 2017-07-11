// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mmc.boot.system.redis.service.impl.RedisOptionService;

/** 
 * ClassName: RedisTest<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class RedisTest {

	@Autowired
	private RedisOptionService redisOptionService;
	
	@Test
	public void test() {
		redisOptionService.setStr("test", "test001");
	}
	
	@Test
	public void testGet() {
		String value = (String) redisOptionService.getObject("test");
		System.out.println(value);
	}
}
