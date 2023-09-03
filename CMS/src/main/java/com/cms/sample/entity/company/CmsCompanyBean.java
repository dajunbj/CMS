package com.cms.sample.entity.company;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//会社Bean
@Data
@Table(name = "cms_company")
public class CmsCompanyBean {
	@Id
	@Column(name = "companyId")
	private String companyId;
	
	//会社名
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "formDay")
	private String formDay;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "joiningDate")
	private String joiningDate;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "registrationDate")
	private String registrationDate;
	
	@Column(name = "scale")	
	private String scale;
	
	@Column(name = "bankName")
	private String bankName;
	
	@Column(name = "bankBranchName")
	private String bankBranchName;
	
	@Column(name = "bankAccountNumber")
	private String bankAccountNumber;
	
	@Column(name = "bankAccountName")
	private String bankAccountName;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "annualProfit")
	private String annualProfit;
	
}
