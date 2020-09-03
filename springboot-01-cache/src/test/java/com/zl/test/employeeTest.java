package com.zl.test;


import com.zl.entity.Employee;
import com.zl.mapper.EmployeeMapper;
import com.zl.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class employeeTest {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisUtil redisUtil;
	
	private String str;



	@Test
	public void testKey(){
	/*	Employee employee = new Employee();
		employee.setdId(1);
		employee.setEmail("w4r52342@qq.com");
		redisUtil.set("kkkkk",employee);*/
		Employee kkkkk = (Employee) redisUtil.get("kkkkk");
		System.out.println(kkkkk);
	}



	
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
