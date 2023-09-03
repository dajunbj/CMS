package com.utils;

import java.util.List;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.base.entity.DepartmentBean;
import com.cms.base.mapper.GeneralMstMapper;


@Service
public class DepartmentUtils {

	@Autowired
	GeneralMstMapper generalMstMapper;

	/**
	 * 選択リストの設定
	 * 
	 * @param key 汎用マスタのキー
	 * @throws SystemException 
	 */
	public List<DepartmentBean> getGeneralMastInfo(String key) throws SystemException {
		

		DepartmentBean dep = new DepartmentBean();
		dep.setDepartmentName(key);
		
		List<DepartmentBean> ret = generalMstMapper.selectDep(dep);
		if (ret == null || ret.size() == 0) {
			throw new SystemException("データがありません");
		}

		return ret;
	
	}

	
}
