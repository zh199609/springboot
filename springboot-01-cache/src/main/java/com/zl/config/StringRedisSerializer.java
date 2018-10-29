package com.zl.config;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;

public class StringRedisSerializer implements RedisSerializer<Object>{
	private final Charset charset;
	 
    private final String target = "\"";
 
    private final String replacement = "";
 
    public StringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }
 
    public StringRedisSerializer(Charset charset) {
        this.charset = charset;
    }

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		 String string = JSON.toJSONString(t);
	        if (string == null) {
	            return null;
	        }
	        string = string.replace(target, replacement);
	        return string.getBytes(charset);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		return (bytes == null ? null : new String(bytes, charset));
	}

}
