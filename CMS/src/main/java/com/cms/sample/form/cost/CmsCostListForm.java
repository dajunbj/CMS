package com.cms.sample.form.cost;

import java.util.List;

import com.cms.base.form.BaseForm;
import com.cms.sample.entity.cost.CmsCostBean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
@Data
public class CmsCostListForm extends BaseForm {

	/* 検索結果 */
	private List<CmsCostBean> results;
	//社員名
	private String name;
	//費用ID
	private String costId;
	//費用発生年月
	private String month;
	//削除対象
	private String delItemIds;

	//----------Session----------
	//社員ID(session引数保存)
	private String sessionEmployeeId;
	//職種(session引数保存)
	private String sessionJobType;
}