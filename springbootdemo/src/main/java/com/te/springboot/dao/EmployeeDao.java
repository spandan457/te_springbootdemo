package com.te.springboot.dao;

import com.te.springboot.dto.EmployeeBean;


public interface EmployeeDao {

	public EmployeeBean authenticate(int id,String pwd);
	
	public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmployee(int id);
	
	public java.util.List<EmployeeBean> getAllEmp();
	
	public boolean addEmployee(EmployeeBean bean);
	
	public boolean updateEmployee(EmployeeBean bean); 
	
}
