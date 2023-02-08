package com.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.users.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empservice;
	@GetMapping("/employeesdata")
	public List<Employee> getEmployees(){
		return this.empservice.getEmployeeData();
	}
	
	

}
