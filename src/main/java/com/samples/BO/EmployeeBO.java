package com.samples.BO;

import java.util.Date;
import java.util.List;

import com.samples.domain.Employee;


public interface EmployeeBO {
	public Integer add(String fname, String lname, Long deptId, Long mgrEmpId, Long salary, Date hireDate, Integer jobId)  throws Exception;
	public List<Employee> listEmployees() throws Exception;
	public Employee getEmployee(Integer empId) throws Exception ;
	public boolean updateEmployeeSalary(Integer empId, Long salary) throws Exception;
	public boolean deleteEmployee(Integer empId) throws Exception;
}
