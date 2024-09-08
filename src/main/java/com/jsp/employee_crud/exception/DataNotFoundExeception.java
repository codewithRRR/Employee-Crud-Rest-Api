package com.jsp.employee_crud.exception;

public class DataNotFoundExeception extends RuntimeException {

	String message = "Data Not found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataNotFoundExeception(String message) {
		super();
		this.message = message;
	}

}
