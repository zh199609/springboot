package com.z.controller;

import com.z.entity.Deptment;
import com.z.entity.Employee;
import com.z.mapper.DeptMapper;
import com.z.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TransactionalTest
 * @Description: TODO
 * @Author: zl
 * @Date: 2019/8/8 21:31
 * @Version: 1.0
 **/

@RestController
public class TransactionalTest {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @GetMapping(value = "/insert1")
    //@Transactional
    public void insert1() {
        Deptment deptment = new Deptment();
        deptment.setDeptmentName("部门名字");
        deptMapper.insertDept(deptment);
        int i = 1/0;
        Employee employee = new Employee();
        employee.setLastName("磊");
        employee.setEmail("qwe");
        employee.setGender(1);
        employee.setdId(1);
        empMapper.insert(employee);
    }


    @GetMapping(value = "/insert2")
    @Transactional
    public void insert2() {
        Deptment deptment = new Deptment();
        deptment.setDeptmentName("部门名字");
        deptMapper.insertDept(deptment);
        int i = 1/0;
        Employee employee = new Employee();
        employee.setLastName("磊");
        employee.setEmail("qwe");
        employee.setGender(1);
        employee.setdId(1);
        empMapper.insert(employee);
    }
}
