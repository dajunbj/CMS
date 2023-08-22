package com.cms.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.base.form.salary.salaryListForm;
import com.utils.ServiceUtils;


@Service
public class salaryServiceImpl implements salaryService {

	/****** （自动依赖注入）功能 ******/
	//@Autowired
	//salaryMapper mapper;

//	@Autowired
//	CommonMapper commonMapper;
//
//	@Autowired
//	HttpSession session;
//
	@Autowired
	ServiceUtils serviceUtils;

//执行检索操作,将检索后的form再返回给MarketStoreListForm
	@Override
	 public salaryListForm select(salaryListForm form) {
	  
	  /*
	   * //StringUtils是JDK提供的一个操作String字符串的工具类。他最大的特点就是对
	   * null是安全的。输入的字符串是null，不会抛出NullPointerException错误。
	   * StringUtils对null做了相应的处理，当传递是null的时候返回的也是null。
	   */
	  
//	  MarketStoreBean input = new MarketStoreBean();
//	  
//	  if (StringUtils.isNotEmpty(form.getStoreName())) {
//	   input.setStoreName(form.getStoreName());
//	  }
//	  
//	  if (StringUtils.isNotEmpty(form.getAddress())) {
//	   input.setAddress(form.getAddress());
//	  }
//	  
//	  List<MarketStoreBean> results = mapper.select(input);
//	  if (results == null || results.size() == 0) {
//	   throw new BusinessException("検索結果はありません。");
//	  }
//	 
//	  form.setResults(results);
	  return form;
//	 }
//	//  插入信息
//		public void insert(MarketStoreForm form) {
//	// 建一个bean储存要插入的数据
//			MarketStoreBean bean = new MarketStoreBean();
//    //之后插入的数据将自动生成id(在原有基础上)
//			String maxId = mapper.selectMaxId();
//			String maxStoreId=String.valueOf(Integer.valueOf(maxId) + 1);
//			
//			
//			bean.setStoreId(maxStoreId); 
//			bean.setStoreName(form.getStoreName());
//			bean.setAddress(form.getAddress());
//			bean.setPhone(form.getPhone());
//			bean.setStartDay(form.getStartDay());
//			bean.setFinishDay(form.getFinishDay());
//			
//			
//			mapper.insert(bean);
//	
//			
//		}
//
//		
//		
//		
//		public MarketStoreForm editInit(MarketStoreForm form) {
//
//			// ログイン情報を検索する
//			MarketStoreBean sqlBean = new MarketStoreBean();
//			sqlBean.setStoreId(form.getStoreId());
//			
//			List<MarketStoreBean> searchResults = mapper.select(sqlBean);
//			if (!CollectionUtils.isEmpty(searchResults)) {
//				MarketStoreBean result = searchResults.get(0);
//
//				form.setStoreId(result.getStoreId()); 
//				form.setStoreName(result.getStoreName()); 
//				
//				form.setAddress(result.getAddress()); 
//				form.setPhone(result.getPhone()); 
//				form.setStartDay(result.getStartDay().toString()); 
//				form.setFinishDay(result.getFinishDay().toString()); 
//			}
//
//			return form;
//		}
//		//@Override
//		//public MarketStoreForm editInit(MarketStoreForm form) {
//			// TODO 自動生成されたメソッド・スタブ
//			//return null;
//		//}
//
//		@Override
//		public void update(MarketStoreForm form) {
//			// TODO 自動生成されたメソッド・スタブ
//			
//			//情报更新
//			// 画面から贩卖店IDを取得する
//			String id = form.getStoreId();
//			// ログイン情報を検索する
//			MarketStoreBean bean = new MarketStoreBean();
//			bean.setStoreId(id);
//
//			List<MarketStoreBean> results = mapper.select(bean);
//			MarketStoreBean updateBean = results.get(0);
//
//			
//			updateBean.setStoreId(form.getStoreId()); // 社員ID
//			updateBean.setStoreName(form.getStoreName()); // 名前
//			updateBean.setAddress(form.getAddress()); // 住所
//			updateBean.setPhone(form.getPhone()); // 携帯
//			updateBean.setStartDay(form.getStartDay());
//			updateBean.setFinishDay(form.getFinishDay());
//			mapper.update(updateBean);
//			//mapper.insert(updateBean);
//		}
//		@Override
//		public MarketStoreForm readInit(MarketStoreForm form) {
//			// TODO 自動生成されたメソッド・スタブ
//			
//			// ログイン情報を検索する
//			MarketStoreBean sqlBean = new MarketStoreBean();
//			sqlBean.setStoreId(form.getStoreId());
//
//			List<MarketStoreBean> searchResults = mapper.select(sqlBean);
//			if (!CollectionUtils.isEmpty(searchResults)) {
//				MarketStoreBean result = searchResults.get(0);
//
//				form.setStoreId(result.getStoreId()); // 社員ID
//				form.setStoreName(result.getStoreName()); // 名前
//				
//				form.setAddress(result.getAddress()); // 住所
//				form.setPhone(result.getPhone()); // 携帯
//				form.setStartDay(result.getStartDay()); 
//				form.setFinishDay(result.getFinishDay());
//				
//			}
//
//			return form;
//			
//		}
//		/**
//		 * ユーザー情報を削除する
//		 * 
//		 * @param form フォーム
//		 * @return 検索結果
//		 */
//		@Override
//		public void delete(String storeId) {
//
//			//楽観チェックを行う
//			//optimismCheck(form);
//			
//			//社員ID
//			//String[] param = form.getSelectedItemId().split("_");
//			//String StoreId = param[0];
//			
//			MarketStoreBean deleteBean = new MarketStoreBean();
//			deleteBean.setStoreId(storeId);
//			mapper.delete(deleteBean);
//			
//			//return form;
//		}
//		/**
//		 * ユーザー情報を削除する
//		 * 
//		 * @param form フォーム
//		 * @return 検索結果
//		 * deleteAll方法，它接收一个类型为String的参数storeIds
//		 */
//		public void deleteAll(String storeIds) {
//			
//			//将一个检索出的id拆分成一个字符串数组，以逗号作为分隔符。
//			mapper.deleteAll(storeIds.split(","));
//
//		//该方法的主要目的是执行删除操作，而不是返回検索結果。
//		}
//
//		@Override
//		public void optimismCheck(MarketStoreListForm form) {
//			// TODO 自動生成されたメソッド・スタブ
//			
//}
//
//
//
//		//public List<MarketStoreBean> readDataFromMysql(MarketStoreReadDataBaseForm form) {
//			// TODO 自動生成されたメソッド・スタブ
//			//return null;
//		//}
//
//		//@Override
//		//public MarketStoreListForm select(MarketStoreForm form) {
//			// TODO 自動生成されたメソッド・スタブ
//			//return null;
//		//}

		

	}		
}