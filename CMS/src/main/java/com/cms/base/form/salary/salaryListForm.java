package com.cms.base.form.salary;

import com.cms.base.form.BaseForm;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ11100
 */
@Getter
@Setter
public class salaryListForm extends BaseForm {

	
	
	private String employeeName;
	private String companyName;
	private String departmentName;
	
	//全删除按钮（复数）
	private String deleteemployeeIds;
	//public String getStoreId();
	//選択対象(ID+最終更新日)
	private String selectedItemId;
		
	//按钮标志（削除、編集ボタン：True；参照：False）
	private boolean btnFlg;

	
	
	/* 検索結果 */
	//private List<sssBean> results;

	

}