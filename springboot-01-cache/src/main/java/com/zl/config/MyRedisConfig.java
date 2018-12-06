package com.zl.config;

import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.util.Assert;

@Configuration
public class MyRedisConfig {
	/*
	 * @Bean public RedisTemplate<Object, Object> redisTemplate(
	 * RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
	 * RedisTemplate<Object, Object> template = new RedisTemplate<>();
	 * template.setConnectionFactory(redisConnectionFactory);
	 * Jackson2JsonRedisSerializer<Object> serializer = new
	 * Jackson2JsonRedisSerializer<>(Object.class); //
	 * 设置值（value）的序列化采用FastJsonRedisSerializer。
	 * template.setValueSerializer(serializer);
	 * template.setHashValueSerializer(serializer); //
	 * 设置键（key）的序列化采用StringRedisSerializer。 template.setKeySerializer(new
	 * StringRedisSerializer()); template.setHashKeySerializer(new
	 * StringRedisSerializer()); template.setDefaultSerializer(serializer);
	 * template.afterPropertiesSet(); System.err.println("序列化完成？？"); return
	 * template; }
	 */

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
		// 设置值（value）的序列化采用FastJsonRedisSerializer。
		//template.setValueSerializer(serializer);
		//template.setHashValueSerializer(serializer);
		// 设置键（key）的序列化采用StringRedisSerializer。
		//template.setKeySerializer(new StringRedisSerializer());
		//template.setHashKeySerializer(new StringRedisSerializer());
		template.setDefaultSerializer(serializer);
		return template;
	}
	
	/*@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration.serializeValuesWith(SerializationPair
                .fromSerializer(serializer));
        RedisCacheManager.RedisCacheManagerBuilder cacheManagerBuilder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration);
        RedisCacheManager cacheManager = cacheManagerBuilder.build();
        Map<String, RedisCacheConfiguration> cacheConfigurations = cacheManager.getCacheConfigurations();
        return cacheManager;
	}*/
	@Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        //使用Jackson2JsonRedisSerializer反序列化时的转换异常
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        //而使用GenericJackson2JsonRedisSerializer就可以避免这种情况。
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        return redisCacheConfiguration.serializeValuesWith(SerializationPair.fromSerializer(new StringRedisSerializer())).serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

}
