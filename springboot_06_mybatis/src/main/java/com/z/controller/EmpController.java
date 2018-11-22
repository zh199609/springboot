package com.z.controller;

import com.z.entity.Employee;
import com.z.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    EmpMapper empMapper;

    @RequestMapping(value = "/emp/{id}")
    public Employee getEmpById(@PathVariable(value = "id") Integer id){
        return empMapper.getEmpById(id);
    }
}
