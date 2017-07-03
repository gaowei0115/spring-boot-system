// Copyright (C) 2016-2017 GWGW All rights reserved
package com.mmc.boot.system.redis.config.serializer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/** 
 * ClassName: RedisObjectSerializer<br/>
 * Description: redis 序列化<br/>
 * Author: GW<br/>
 * Create： 2017年7月3日<br/>
 *
 * History: (Version) Author dateTime description <br/>
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

	private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];
    
	/* (non-Javadoc)
	 * @see org.springframework.data.redis.serializer.RedisSerializer#deserialize(byte[])
	 */
	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (isEmpty(bytes)) {
            return null;
        }

        try {
            return deserializer.convert(bytes);
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.serializer.RedisSerializer#serialize(java.lang.Object)
	 */
	@Override
	public byte[] serialize(Object object) throws SerializationException {
		if (object == null) {
            return EMPTY_ARRAY;
        }

        try {
            return serializer.convert(object);
        } catch (Exception ex) {
            return EMPTY_ARRAY;
        }
	}

	/**
	 * Description：<br/>
	 * Author：GW<br/>
	 * History: (Version) Author dateTime description <br/>
	 * @param data
	 * @return
	 */
	private boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
	
}
