package com.cms.sample.service.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.sample.entity.company.CmsCompanyBean;
import com.cms.sample.entity.employee.CmsEmployeeBean;
import com.cms.sample.mapper.employee.CmsEmployeeMapper;

/**
 * 社員選択画面 Service
 */
@Service
public class CmsSelectEmployeeServiceImpl implements CmsSelectEmployeeService {

	/****** Mapper ******/
	@Autowired
	CmsEmployeeMapper businessMapper;

	/**
	 * 社員選択画面_検索処理
	 * 
	 * @param bean 社員Bean
	 * @return 検索結果
	 */
	public List<CmsEmployeeBean> select(CmsEmployeeBean bean) {
		
		List<CmsEmployeeBean> retList = businessMapper.select(bean);
		
		return retList;
	}

	/**
	 * 社員選択画面_検索処理
	 * 
	 * @param bean 会社Bean
	 * @return 検索結果
	 */
	@Override
	public List<CmsCompanyBean> selectCoapany(CmsCompanyBean bean) {
		List<CmsCompanyBean> retList = businessMapper.selectCompany(bean);
		
		return retList;
	}


}