package com.zl.controller;

import com.zl.dao.DepartmentDao;
import com.zl.dao.EmployeeDao;
import com.zl.entities.Department;
import com.zl.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 进入员工列表页面
     * @return
     */@GetMapping(value = "/emps")
    public String list(Model model){
        Collection<Employee> list = employeeDao.getAll();
        model.addAttribute("emps",list);
        return "emp/list";
    }

    @GetMapping(value = "emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping(value = "emp")
    public String addEmp(Employee employee){
         employeeDao.save(employee);
         return "redirect:/emps";
    }

    /**
     * 来到添加页面
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable(value = "id")Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping(value = "emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable(value = "id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
