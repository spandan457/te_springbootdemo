package com.te.springboot.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("employee_response")
@JsonPropertyOrder({ "statusCode", "msg" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse implements Serializable {

	private int statusCode;

	private String msg;

	private String description;

	@JsonProperty("employee_info")
	private EmployeeBean bean;
	
	@JsonProperty("employee_details")
	private List<EmployeeBean>  employeeBeans;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EmployeeBean getBean() {
		return bean;
	}

	public void setBean(EmployeeBean bean) {
		this.bean = bean;
	}

	public List<EmployeeBean> getEmployeeBeans() {
		return employeeBeans;
	}

	public void setEmployeeBeans(List<EmployeeBean> employeeBeans) {
		this.employeeBeans = employeeBeans;
	}
	
}
