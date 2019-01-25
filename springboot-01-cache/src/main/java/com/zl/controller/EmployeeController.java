package com.zl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zl.entity.Employee;
import com.zl.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "emp/{id}")
	public Employee getEmpById(@PathVariable(value = "id") Integer id) {

		return employeeService.getEmpById(id);
	}

	@RequestMapping(value = "update")
	public Employee update(Employee employee) {
		return employeeService.updateEmp(employee);
	}

	@RequestMapping(value = "delete/{id}")
	public String delet(@PathVariable(value = "id") Integer id) {
		employeeService.deleteEmp(id);
		return "1";
	}

	@RequestMapping(value = "delete/{name}")
	public String getEmpByLastName(@PathVariable(value = "name") String name) {
		employeeService.getEmpByLastName(name);
		return "1";
	}
}
