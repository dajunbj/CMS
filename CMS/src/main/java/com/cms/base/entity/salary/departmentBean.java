package com.cms.base.entity.salary;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Data


@Table(name = "cms_department")
public class departmentBean {
	
	
	@Column(name = "departmentName")
	private String departmentName;
	


}
