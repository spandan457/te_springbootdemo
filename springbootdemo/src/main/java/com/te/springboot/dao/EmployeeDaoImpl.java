package com.te.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.springboot.dto.EmployeeBean;
import com.te.springboot.exception.EmpException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public EmployeeBean authenticate(int id, String pwd) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			if (bean != null) {
				if (bean.getPassword().equals(pwd)) {
					System.out.println("login successful");
					return bean;
				} else {
					System.out.println("invalid credentials");
					return null;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} // end of authenticate
		return null;

	}

	@Override
	public EmployeeBean getEmployee(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();
		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			if (bean != null) {
				return bean;
			} else {
				System.out.println("employee not found ");
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} // end of getEmployee

	}

	@Override
	public boolean deleteEmployee(int id) {

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		} else {
			return false;
		}

	}// end of delete employee

	@Override
	public List<EmployeeBean> getAllEmp() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		String query = "from EmployeeBean";

		javax.persistence.Query query2 = manager.createQuery(query);

		List<EmployeeBean> list = query2.getResultList();
		if (list != null) {
			return list;
		} else {
			return null;
		}

	}// end of getalldata method

	@Override
	public boolean addEmployee(EmployeeBean bean) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		boolean isadded =false;
		try {

			transaction.begin();

			manager.persist(bean);

			transaction.commit();
			isadded= true;

			
		} catch (Exception e) {
			transaction.rollback();
		
			throw new EmpException("Duplicate found");
		}
		return isadded;

	}// end of addEmployee method

	
		
		@Override
		public boolean updateEmployee(EmployeeBean bean) {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			boolean isUpdated = false;

			try {
				transaction.begin();
				EmployeeBean info = manager.find(EmployeeBean.class, bean.getId());
				if (bean.getName() != null && bean.getName() != "") {
					info.setName(bean.getName());
				}
				if (bean.getBirthDate() != null) {
					info.setBirthDate(bean.getBirthDate());
				}

				if (bean.getPassword() != null && bean.getPassword() != "") {
					info.setPassword(bean.getPassword());
				}

				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {

				e.printStackTrace();
			}

			return isUpdated;
		

	
	}
}
