// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis.service;

import java.util.List;

/**
 * ClassName: RedisService<br/>
 * Description: redis缓存操作<br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public interface RedisOptionService {

	public boolean set(String key, String value);

	public String get(String key);

	public boolean expire(String key, long expire);

	public <T> boolean setList(String key, List<T> list);

	public <T> List<T> getList(String key, Class<T> clz);

	public long lpush(String key, Object obj);

	public long rpush(String key, Object obj);

	public String lpop(String key);
}
