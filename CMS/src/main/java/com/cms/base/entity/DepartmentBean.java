package com.cms.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 Entity
 */
@Getter
@Setter
@Entity
@Table(name = "cms_department")
public class DepartmentBean {

	@Id
	@Column(name = "departmentId")
	private String departmentId;
	
	@Column(name = "departmentName")
	private String departmentName;
	
	@Column(name = "responsiblePerson")
	private String responsiblePerson;
	
	@Column(name = "departmentEstablishmentDate")
	private String departmentEstablishmentDate;

}
