package com.cms.sample.form.company;

import java.util.List;

import com.cms.base.form.BaseForm;
import com.cms.sample.entity.company.CmsCompanyBean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
@Data
public class CmsCompanyForm extends BaseForm {

	/* 検索結果 */
	private List<CmsCompanyBean> results;

	private String employeeId;

	
	//所属会社
	private String companyName;
	private String companyID;
	

}