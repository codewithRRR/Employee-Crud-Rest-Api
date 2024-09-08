package com.jsp.employee_crud.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class DataExistException extends RuntimeException {
	String message = "Data already exists";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataExistException(String message2) {
		// TODO Auto-generated constructor stub
	}
}