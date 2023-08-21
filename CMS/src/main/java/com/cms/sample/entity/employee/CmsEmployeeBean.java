package com.cms.sample.entity.employee;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "cms_employee")
public class CmsEmployeeBean {
	@Id
	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "employeeName")
	private String employeeName;
	
	@Column(name = "sex")
	private String sex;
	private String sexForList;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "joiningDate")
	private String joiningDate;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "jobType")
	private String jobType;
	
//	@Column(name = "jobLevel")
//	private String jobLevel;

	@Column(name = "loginId")
	private String loginId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "registDay")
	private String registDay;
	
	@Column(name = "updateDay")
	private String updateDay;
	
	
}
