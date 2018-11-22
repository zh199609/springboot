package com.z.controller;

import com.z.entity.Deptment;
import com.z.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @RequestMapping(value = "/dept/{id}")
    public Deptment getDept(@PathVariable(value = "id") Integer id){
        return deptMapper.getDeptById(id);
    }

    @RequestMapping(value = "insertDept")
    public Deptment insertDept(Deptment deptment){
        deptMapper.insertDept(deptment);
        return deptment;
    };
}
