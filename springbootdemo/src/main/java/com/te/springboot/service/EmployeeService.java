package com.te.springboot.service;

import java.util.List;

import com.te.springboot.dto.EmployeeBean;

public interface EmployeeService {

public EmployeeBean authenticate(int id,String pwd);
	
	public EmployeeBean getEmployeeBean(int id);
	
	public boolean deleteEmployee(int id);
	
	public java.util.List<EmployeeBean> getAllEmp();
	
	public boolean addEmployee(EmployeeBean bean);
	
	public boolean updateEmployee(EmployeeBean bean);


}
