package com.zl.test;



import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zl.entity.Employee;
import com.zl.mapper.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class employeeTest {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private String str;
	
	@Test
	public void testResis() {
		
		//操作字符串
		//stringRedisTemplate.opsForValue().append("redis", "zl");
		Employee empById = employeeMapper.getEmpById(1);
		//默认保存对象，使用jdk序列化
		redisTemplate.opsForValue().set("emp01", empById);
		//将数据以json保存
		//redisTemplate  有默认序列化器
		
	}
	
	
	
	@Test
	public void testGetEmp() {
		Employee empById = employeeMapper.getEmpById(1);
		System.out.println(empById);
	}

}
