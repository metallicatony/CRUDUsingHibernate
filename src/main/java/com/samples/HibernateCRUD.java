package com.samples;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samples.BO.EmployeeBO;
import com.samples.BO.impl.EmployeeBOImpl;
import com.samples.domain.Employee;


/**
 * @author skanniah
 *
 */
public class HibernateCRUD 
{

	private static EmployeeBO employeeBO = new EmployeeBOImpl();
    private static Logger log = LoggerFactory.getLogger(HibernateCRUD.class);
	
	public static Integer createEmployee(String fname, String lname, Long deptId,
			Long mgrEmpId, Long salary, Date hireDate, Integer jobId) {
		log.info("calling createEmployee");
		try {
			Integer newEmpId = employeeBO.add(fname, lname, deptId, mgrEmpId, salary, hireDate, jobId);
			return newEmpId;
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return null;
	}
	
	public static List<Employee> getAllEmployees() {
		log.info("list Employees");
		List<Employee> empList = null;
		try {
			empList = employeeBO.listEmployees();
			log.info("empList size=" + empList.size());
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return empList;
	}
	
	public static Employee getEmployee(Integer empId) {
		log.info("get employee");
		try {
			return employeeBO.getEmployee(empId);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return null;
	}
	
	public static boolean updateEmployeeSalary(Integer empId, Long salary) {
		log.info("update employee");
		boolean result = false;
		try {
			result = employeeBO.updateEmployeeSalary(empId, salary);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return result;
	}
	
	public static boolean deleteEmployee(Integer empId) {
		log.info("delete employee");
		boolean result = false;
		try {
			result = employeeBO.deleteEmployee(empId);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return result;
	}
	
    public static void main( String[] args )
    {   
    	 /* Create operation */
		Integer newEmpId = createEmployee("Marlon", "Samuels", new Long(99), new Long(7566),
				new Long(1500), Calendar.getInstance().getTime(), new Integer(
						777));
		log.info("employee created with empId=" + newEmpId);
		
    	/* List operation */
    	List<Employee> empList = getAllEmployees();
		for (Employee emp : empList) {
			log.info("EmployeeId=" + emp.getEmpId() + " FirstName="
					+ emp.getFname() + " LastName=" + emp.getLname());
		}
    	
    	/* get operation */
    	Integer prevEmpId = newEmpId - 1;
    	Employee emp = getEmployee(prevEmpId);
		if (emp != null) {
			log.info("employee name=" + emp.getFname() + " " + emp.getLname());
		}
		else {
			log.info("NO employee found with empId=" + prevEmpId);
		}
		
		/* Update Operation */
		boolean updateResult = updateEmployeeSalary(prevEmpId, new Long("2000"));
		if (updateResult) {
			log.info("salary of empId=" + prevEmpId + " updated");
		}
		else {
			log.info("salary of empId=" + prevEmpId + " NOT updated");
		}
		
		Integer penUltimateEmpId = newEmpId - 2;
		/* delete operation */
		boolean deleteResult = deleteEmployee(penUltimateEmpId);
		if (deleteResult) {
			log.info("deleted employee with empId=" + penUltimateEmpId);
		}
		else {
			log.info("employee empId=" + penUltimateEmpId + " NOT deleted");
		}
	}
}
