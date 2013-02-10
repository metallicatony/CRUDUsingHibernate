package com.samples.DAO;
import java.util.List;

import com.samples.domain.Employee;

public interface EmployeeDAO {
	public Integer add(Employee empl) throws Exception;
	public List<Employee> listEmployees() throws Exception;
	public Employee getEmployee(Integer empId) throws Exception;
	public boolean updateEmployeeSalary(Integer empId, Long salary) throws Exception;
	public boolean deleteEmployee(Integer empId) throws Exception;
}

