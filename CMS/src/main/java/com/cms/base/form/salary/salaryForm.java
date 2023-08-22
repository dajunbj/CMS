package com.cms.base.form.salary;

import java.util.List;

import com.cms.base.entity.salary.employeeBean;
import com.cms.base.form.BaseForm;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
@Data
public class salaryForm extends BaseForm {

	
	
	
	private String employeeId;
	//@NotEmpty
	private String employeeName;
	//@NotEmpty
	private String affiliatedCompany;
	//@NotEmpty
	private String departmentName;
	
	//@NotEmpty
	private String jobStatus;
	//@NotEmpty
	private String changeDate;
	
//	public void setResults(List<MarketStoreBean> results) {
//		// TODO 自動生成されたメソッド・スタブ
//		
//	}
	
	/* 検索結果 */
	private List<employeeBean> results;
}