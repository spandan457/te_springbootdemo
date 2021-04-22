package com.te.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.te.springboot.dto.EmployeeResponse;
import com.te.springboot.exception.EmpException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(EmpException.class)
	public EmployeeResponse handler(EmpException empException) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setStatusCode(500);
		employeeResponse.setMsg("found duplicate value");
		employeeResponse.setDescription("Data already present");
		return employeeResponse;
	}

}
