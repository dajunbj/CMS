package com.cms.sample.form.cmsemployee;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import com.cms.base.form.BaseForm;
import com.cms.sample.entity.employee.CmsEmployeeBean;

import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
public class CmsEmployeeListForm extends BaseForm {

	/* 検索結果 */
	private List<CmsEmployeeBean> results;

	/* 画面からの入力値 */
	private String employeeId;

	private String employeeName;
	
	//会社名
	private String companyName;
	
	//部門名
	private String departmentName;
	private Map<String, String> departmentList;
			
	private String jobType;
	
	//生年月
	private String month;

	//職種選択リスト
	@NotEmpty
	private String selectedJobType;
	private Map<String, String> jobTypeList;

	//性別選択リスト
	@NotEmpty
	private String selectedSexy;
	private Map<String, String> sexyList;

	//全選択の削除対象
	private String selectedItemIds;
	
	//選択対象(ID+最終更新日)
	private String selectedItemId;
	
	//ボタンフラグ（削除、編集ボタン：True；参照：False）
	private boolean btnFlg;

}