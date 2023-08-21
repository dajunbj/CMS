package com.cms.base.entity.salary;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Data


@Table(name = "cms_salary_change")
public class salaryBean {
	
	
	@Column(name = "newSalary")
	private String newSalary;
	
	@Column(name = "changeDate")
	private String changeDate;
	

}
