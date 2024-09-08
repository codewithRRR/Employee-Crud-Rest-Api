package com.jsp.employee_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee_crud.dto.Employee;
import com.jsp.employee_crud.helper.ResponseStructure;
import com.jsp.employee_crud.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@Operation(summary = "save on employee", description = "Don't Enter the Id")
	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.save(employee);

	}

	@Operation(summary = "save employees-multiple")
	@PostMapping("/employess/many")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(@RequestBody List<Employee> employee) {
		return service.saveAll(employee);
	}

}
