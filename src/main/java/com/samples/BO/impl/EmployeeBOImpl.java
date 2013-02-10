package com.samples.BO.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.samples.BO.EmployeeBO;
import com.samples.DAO.EmployeeDAO;
import com.samples.DAO.impl.EmployeeDAOImpl;
import com.samples.domain.Employee;

public class EmployeeBOImpl implements EmployeeBO {
	
	private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	public Integer add(String fname, String lname, Long deptId, Long mgrEmpId, Long salary, Date hireDate, Integer jobId) 
			throws Exception {
		Integer empId = null;
		// Create Employee here
		// Do other business validations here for all the values
		Employee employee = new Employee();
		employee.setDeptId(deptId);
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setMgrEmpId(mgrEmpId);
		employee.setSalary(salary);
		employee.setHireDate(hireDate);
		employee.setJobId(jobId);
		employee.setActive(true);
		
		if (employee != null) {
			empId = employeeDAO.add(employee);
		}
		return empId;
	}

	public List<Employee> listEmployees() throws Exception {
		return employeeDAO.listEmployees();
	}

	public Employee getEmployee(Integer empId) throws Exception {
		return employeeDAO.getEmployee(empId);
	}
	
	public boolean updateEmployeeSalary(Integer empId, Long salary) throws Exception {
		return employeeDAO.updateEmployeeSalary(empId, salary);
	}
	
	public boolean deleteEmployee(Integer empId) throws Exception {
		return employeeDAO.deleteEmployee(empId);
	}

}
