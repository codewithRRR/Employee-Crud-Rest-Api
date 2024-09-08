package com.jsp.employee_crud.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.employee_crud.helper.ResponseStructure;

@RestControllerAdvice
public class MyExceptionHandler {

	@Autowired
	ResponseStructure<String> structure;

	@ExceptionHandler(DataExistException.class)

	public ResponseEntity<ResponseStructure<String>> handle(DataExistException exception) {
		structure.setMessage("Data Already exists");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
}

