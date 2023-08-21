package com.cms.base.form.salary;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cms.base.entity.salary.salaryBean;
import com.cms.base.form.BaseForm;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
public class salaryListForm extends BaseForm {

	
	@NotEmpty
	private String employeeName;
	private String companyName;
	private String departmentName;
	
	//全删除按钮（复数）
	private String deleteStoreIds;
	//public String getStoreId();
	//選択対象(ID+最終更新日)
	private String selectedItemId;
		
	//按钮标志（削除、編集ボタン：True；参照：False）
	private boolean btnFlg;

	
	
	/* 検索結果 */
	private List<salaryBean> results;

	

}