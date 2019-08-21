package com.z.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z.entity.Deptment;
import com.z.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;

    @RequestMapping(value = "/dept/{pageNum}/{pageSize}")
    public List<Deptment> getDept(@PathVariable(value = "pageNum") Integer pageNum,@PathVariable(value = "pageSize")Integer pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<Deptment> depts = deptMapper.getDepts();
        PageInfo pageInfo = new PageInfo(depts);
        System.out.println("pageInfo:"+pageInfo);
        return depts;

    }

    @RequestMapping(value = "insertDept")
    public Deptment insertDept(Deptment deptment){
        deptMapper.insertDept(deptment);
        return deptment;
    };
}
