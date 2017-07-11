// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * ClassName: RedisOptionService<br/>
 * Description: <br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
@Service("redisOption")
public class RedisOptionService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 保存String数据
	 * 
	 * @Title: setStr
	 * @param key
	 * @param value
	 *
	 */
	public void setStr(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public String getString(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}

	/**
	 * 操作对象
	 * 
	 * @Title: setObject
	 * @param key
	 * @param obj
	 *
	 */
	public void setObject(String key, Object obj) {
		redisTemplate.opsForValue().set(key, obj);
	}

	public Object getObject(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 保存List数据存储
	 * 
	 * @param key
	 * @param listValue
	 * @return
	 */
	public void setList(String key, List<?> listValue) {
		redisTemplate.opsForList().leftPush(key, listValue);
	}

	public List<?> getList(String key) {
		return (List<?>) redisTemplate.opsForList().range(key, 0, -1);
	}

	/**
	 * 保存Map数据存储
	 * 
	 * @param key
	 * @param mapValue
	 * @return
	 */
	public void setMap(String key, Map<Object, Object> mapValue) {
		redisTemplate.opsForHash().putAll(key, mapValue);
	}

	public Map<Object, Object> getMap(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	/**
	 * 保存Set数据存储
	 * 
	 * @param key
	 * @param setValue
	 * @return
	 */
	public void setSet(String key, Set<?> setValue) {
		redisTemplate.opsForSet().add(key, setValue);
	}

	public Set<?> getSet(String key) {
		return (Set<?>) redisTemplate.opsForSet().members(key);
	}
}
