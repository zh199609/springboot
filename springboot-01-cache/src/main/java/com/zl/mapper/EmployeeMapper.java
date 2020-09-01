package com.zl.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zl.entity.Employee;

@Mapper
public interface EmployeeMapper {

	@Select("select * from employee where id = #{id}")
	Employee getEmpById(Integer id);
	
	@Update("update employee set lastname = #{lastName},email=#{email} where id = #{id}")
	void updateEmp(Employee employee);
	
	@Delete("delete from employee where id = #{id}")
	void deleteEmpById(Integer id);
	
	@Insert("insert into employee(lastname,email,gendern,d_id) values(#{lastName},#{email},#{gendern},#{dId})")
	void insertEmp(Employee employee);
	
	@Select("select * from employee where lastName = #{name}")
	Employee getEmpByLastName(String name);
}
