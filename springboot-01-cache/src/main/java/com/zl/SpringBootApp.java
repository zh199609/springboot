package com.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
/**
 * 
 * @author zhanglei
 *	
 *		1.开启基于注解的缓存@EnableCaching
 *		2.标注缓存注解
 *			@Cacheable
 *			@CacheEvict
			@CachePut
 *
 */
@EnableCaching
@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
}
