// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * ClassName: Application<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
@SpringBootApplication
public class Application {

	// logger
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		logger.info("start application ....");
		SpringApplication.run(Application.class, args);
	}
}
