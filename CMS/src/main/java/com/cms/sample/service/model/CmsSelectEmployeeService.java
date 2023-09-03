package com.cms.sample.service.model;

import java.util.List;

import com.cms.sample.entity.company.CmsCompanyBean;
import com.cms.sample.entity.employee.CmsEmployeeBean;

/**
 * 社員選択画面 Service
 */
public interface CmsSelectEmployeeService {

	/**
	 * 社員選択画面_検索処理
	 * 
	 * @param bean 社員Bean
	 * @return List<CmsEmployeeBean> 検索結果
	 */	
	public List<CmsEmployeeBean> select(CmsEmployeeBean bean);
	
	/**
	 * 会社選択画面_検索処理
	 * 
	 * @param bean 会社Bean
	 * @return List<CmsCompanyBean> 検索結果
	 */	
	public List<CmsCompanyBean> selectCoapany(CmsCompanyBean bean);
	
	
	
}
