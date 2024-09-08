package com.jsp.employee_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.employee_crud.dto.Employee;
import com.jsp.employee_crud.exception.DataExistException;
import com.jsp.employee_crud.helper.ResponseStructure;
import com.jsp.employee_crud.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	ResponseStructure<Employee> structure;

	@Autowired
	ResponseStructure<List<Employee>> structure2;

	public ResponseEntity<ResponseStructure<Employee>> save(Employee employee) {
		if (repository.existsByMobile(employee.getMobile())) {
			throw new DataExistException("Mobile number is Repeated :" + employee.getMobile());

		} else {
			repository.save(employee);
			structure.setMessage("Data Saved success");
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);

		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> saveAll(List<Employee> employees) {
		for (Employee employee : employees) {
			if (repository.existsByMobile(employee.getMobile())) {
				throw new DataExistException("Mobile number is reapeated : " + employee.getMobile());
			}

		}
		{
			repository.saveAll(employees);
			structure2.setMessage("Data saved  success");
			structure2.setData(employees);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure2, HttpStatus.CREATED);
		}
	}
}
