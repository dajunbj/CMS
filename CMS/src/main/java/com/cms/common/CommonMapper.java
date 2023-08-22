package com.cms.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cms.base.entity.MCodeMstBean;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface CommonMapper {
	/**
	 * コードマスタを取得する
	 * 
	 * @param bean 検索用リクエストデータ
	 * @return コードマスタ情報
	 */
	List<MCodeMstBean> select(MCodeMstBean bean);

}