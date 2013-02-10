package com.samples.DAO.impl;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samples.HibernateUtil;
import com.samples.DAO.EmployeeDAO;
import com.samples.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger log = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	public Integer add(Employee empl) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer empId = null;
		
		try {
			tx = session.beginTransaction();
			empId = (Integer) session.save(empl);
			tx.commit();
		} catch (HibernateException e) {
			log.error("hibernate exception received while creating a new employee", e);
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}
		return empId;
	}

	public List<Employee> listEmployees() throws Exception {
		Transaction tx = null;
		List<Employee> empList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			tx = session.beginTransaction();
			empList = session.createQuery("from Employee").list();
			tx.commit();
		} catch (HibernateException e) {
			log.error("hibernate exception received while listing ALL employees", e);
			if (tx != null) {
				tx.rollback();
				throw e;
			}
		} finally {
			session.close();
		}
		
		return empList;
	}
	
	public Employee getEmployee(Integer empId) throws Exception {
		Transaction tx = null;
		Employee emp = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			emp = (Employee) session.get(Employee.class, empId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("hibernate exception received while getting info about an employee");
			throw e;
		} finally {
			session.close();
		}
		return emp;
	}
	
	public boolean updateEmployeeSalary(Integer empId, Long salary) throws Exception {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		try {
			tx = session.beginTransaction();
			Employee emp = (Employee) session.get(Employee.class, empId);

			if (emp != null) {
				emp.setSalary(salary);
				session.saveOrUpdate(emp);
				tx.commit();
				result = true;
			}
		} catch (HibernateException e) {
			log.error("hibernate exception received while updating the salary of an employee");
			throw e;
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean deleteEmployee(Integer empId) throws Exception {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		try {
			tx = session.beginTransaction();
			Employee emp = (Employee) session.get(Employee.class, empId);
			if (emp != null) {
				session.delete(emp);
				tx.commit();
				result = true;
			}
		} catch (HibernateException e) {
			log.error("hibernate exception received while deleting an employee");
			throw e;
		} finally {
			session.close();
		}
		return result;
	}
}
