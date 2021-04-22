package com.te.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.dao.EmployeeDao;
import com.te.springboot.dto.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Override
	public EmployeeBean getEmployeeBean(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public EmployeeBean authenticate(int id, String pwd) {
		// TODO Auto-generated method stub
		return dao.authenticate(id, pwd);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		// TODO Auto-generated method stub
		return dao.getAllEmp();
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(bean);
	}




}
