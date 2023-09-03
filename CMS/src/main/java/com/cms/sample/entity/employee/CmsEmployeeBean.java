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
	
	//部門名
	@Column(name = "departmentName")
	private String departmentName;
	
	//部門ID
	@Column(name = "departmentID")
	private String departmentID;
	
	//在職状況
	@Column(name = "jobStatus")
	private String jobStatus;
	
	//職種
	@Column(name = "jobType")
	private String jobType;
	
	@Column(name = "loginId")
	private String loginId;
	
	@Column(name = "password")
	private String password;
	
	//削除フラグ
	@Column(name = "delFlg")
	private String delFlg;
	
	@Column(name = "registDay")
	private String registDay;
	
	@Column(name = "updateDay")
	private String updateDay;
	
	//社員テーブル会社Id
	@Column(name = "companyID")	
	private String companyID;
	
	//会社テーブル会社Id
	@Column(name = "companyId")	
	private String companyId;
	
	//会社名
	@Column(name = "companyName")
	private String companyName;	
	
	//権限ID
	@Column(name = "permissonID")
	private String permissonID;
	
	//緊急連絡先一覧
	@Column(name = "u_name")
	private String u_name;
	
	@Column(name = "u_address")
	private String u_address;
	
	@Column(name = "u_phone")
	private String u_phone;
	
	@Column(name = "relationship")
	private String relationship;
	
}
