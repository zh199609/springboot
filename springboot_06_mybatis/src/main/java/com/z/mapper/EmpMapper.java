package com.z.mapper;

import com.z.entity.Employee;
import org.apache.ibatis.annotations.Insert;

public interface EmpMapper {
    Employee getEmpById(Integer id);
    @Insert("insert into employee(last_name,gender,email,d_id) values(#{lastName},#{gender},#{email},#{d_id})")
    void insert(Employee employee);
}
