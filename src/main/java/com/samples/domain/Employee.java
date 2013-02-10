package com.samples.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




/**
 * @author skanniah
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="EMP_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
	@SequenceGenerator(name="emp_id_seq", sequenceName="emp_id_sequence", allocationSize=1)
	private Integer empId;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="DEPT_ID")
	private Long deptId;
	
	@Column(name="MANAGER_EMP_ID")
	private Long mgrEmpId;
	
	@Column(name="SALARY")
	private Long salary;
	
	@Column(name="HIRE_DATE")
	private Date hireDate;
	
	@Column(name="JOB_ID")
	private Integer jobId;
	
	@Column(name="ACTIVE")
	@org.hibernate.annotations.Type(type="yes_no")
	private Boolean active;

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
	public Long getMgrEmpId() {
		return mgrEmpId;
	}
	public void setMgrEmpId(Long mgrEmpId) {
		this.mgrEmpId = mgrEmpId;
	}
	
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
