package com.cms.base.entity.salary;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "cms_employee")

public class employeeBean {
	@Id
	@Column(name = "employeeId")
	private String cms_salary_change;
	
	@Column(name = "employeeName")
	private String employeeName;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "departmentName")
	private String departmentName;
	
	@Column(name = "newSalary")
	private String newSalary;
	
	@Column(name = "jobStatus")
	private String jobStatus;
	
	@Column(name = "changeDate")
	private String changeDate;
	
	

}
