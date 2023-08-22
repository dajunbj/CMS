package com.cms.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cms.base.entity.salary.employeeBean;

/**
 * 贩卖店情報 Mapper
 */
@Mapper
public interface salaryMapper {
	/**
	 * 贩卖店件数の取得
	 * 
	 * @param bean 社員Bean
	 * @return レコード件数
	 */
	Integer selectRecordCount(employeeBean bean);
	
	/**
	 * 贩卖店情報検索
	 * 
	 * @param user 検索用リクエストデータ
	 * @return ユーザー情報
	 */
	List<employeeBean> select(employeeBean bean);
	
//最大id取得
	
	String selectMaxId();
	
	/**
	 * 贩卖店情報検索
	 * 
	 * @param user 検索用リクエストデータ
	 * @return ユーザー情報
	 */
	

	/**
	 * 贩卖店情報登録
	 * 
	 * @param bean 検索用リクエストデータ
	 * @return denglu件数
	 */
	int insert(employeeBean bean);
	/**
	 * 贩卖店情報更新
	 * 
	 * @param user 検索用リクエストデータ
	 * @return 更新件数
	 */
	int update(employeeBean bean);
	
	/**
	 *贩卖店情報削除
	 * 
	 * @param user 検索用リクエストデータ
	 * @return 更新件数 定义了一个全删除的方法
	 */
	int delete(employeeBean bean);
	
	/**
	 * 情報削除
	 * 
	 * @param ids 削除ID配列
	 * @return 削除件数
	 */
	int deleteAll(String[] ids);

	//Integer selectRecordCount(MarketStoreBean sellectBean);

}