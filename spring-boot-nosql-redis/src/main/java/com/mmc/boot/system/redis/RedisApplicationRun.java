// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/** 
 * ClassName: Application<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
@SpringBootApplication
@ComponentScan("com.mmc.boot.system.redis")
@EnableCaching
public class RedisApplicationRun {

	// logger
	private static final Logger logger = LoggerFactory.getLogger(RedisApplicationRun.class);

	public static void main(String[] args) {
		SpringApplication.run(RedisApplicationRun.class, args);
	}
}
