package com.cms.base.service;

import com.cms.base.form.salary.salaryListForm;

public interface salaryService {

	/**
	 * 一覧画面
	 */	
	//一覧画面検索
	public salaryListForm select(salaryListForm form);
//	//这是一个用于插入数据的方法
//	public void insert(salaryForm form);
//
//	/**
//	 * 更新画面
//	 */	
//	//更新画面【初期化】
//	public salaryForm editInit(salaryForm form);
//	//更新画面【データ保存】	
//	public void update(salaryForm form);
//	
//	//明细数据删除	
//	public void delete(String storeId);
//	/**
//	 * 情報を全部除
//	 * 
//	 * @param form フォーム
//	 * @return 検索結果
//	 */
//	
//	public void deleteAll(String storeIds);
//	/**
//	 * 参照画面
//	 */	
//	//参照画面【初期化】
//	public salaryForm readInit(salaryForm form);
//
//	public void optimismCheck(salaryListForm form);
//		
////		MarketStoreListForm select(MarketStoreForm form);
//		
//	
//
//		//public void optimismCheck(MarketStoreListForm form);
			
}
