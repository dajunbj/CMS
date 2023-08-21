package com.cms.base.entity.salary;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Data


@Table(name = "cms_company")
public class companyBean {
	
	
	@Column(name = "companyName")
	private String companyName;
	


}
