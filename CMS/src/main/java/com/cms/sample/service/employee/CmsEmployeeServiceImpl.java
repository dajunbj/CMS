package com.cms.sample.service.employee;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.base.entity.DepartmentBean;
import com.cms.base.mapper.CommonMapper;
import com.cms.base.mapper.GeneralMstMapper;
import com.cms.common.MessageConst;
import com.cms.sample.entity.employee.CmsEmployeeBean;
import com.cms.sample.form.cmsemployee.CmsEmployeeForm;
import com.cms.sample.form.cmsemployee.CmsEmployeeListForm;
import com.cms.sample.mapper.employee.CmsEmployeeMapper;
import com.exception.BusinessException;
import com.utils.CmsUtils;
import com.utils.ServiceUtils;

/**
 * ユーザー情報 Service
 */
@Service
public class CmsEmployeeServiceImpl implements CmsEmployeeService {

	/****** Mapper ******/
	@Autowired
	CmsEmployeeMapper mapper;

	@Autowired
	CommonMapper commonMapper;

	@Autowired
	HttpSession session;

	@Autowired
	ServiceUtils serviceUtils;
	
	@Autowired
	GeneralMstMapper generalMstMapper;

	
	/**
	 * ユーザー情報検索 @param userSearchRequest リクエストデータ
	 * 
	 * @return 検索結果
	 */
	public CmsEmployeeListForm select(CmsEmployeeListForm form) {
		// ログイン情報を検索する
		CmsEmployeeBean bean = new CmsEmployeeBean();
		
		//社員名
		//bean.setEmployeeName(CmsUtils.formatEmptyToNull(form.getEmployeeName()));
		if(StringUtils.isNotEmpty(form.getEmployeeName())){
			bean.setEmployeeName(form.getEmployeeName());
		}
		
		//性別
		if (!"2".equals(form.getSelectedSexy())){
			bean.setSex(CmsUtils.formatEmptyToNull(form.getSelectedSexy()));
		}
		
		if(StringUtils.isNotEmpty(form.getDepartmentName())){
			bean.setDepartmentName(form.getDepartmentName()); 
		}
		
		if(StringUtils.isNotEmpty(form.getCompanyName())) {
			bean.setCompanyName(form.getCompanyName());
		}


		List<CmsEmployeeBean> retList = mapper.select(bean);
		if (retList == null || retList.size() == 0) {
			throw new BusinessException("検索結果はありません。");
		}
		//検索
		form.setResults(retList);

		return form;
	}

	/**
	 * ユーザー情報検索
	 * 
	 * @param form フォーム
	 * @return 検索結果
	 */
	public CmsEmployeeForm insert(CmsEmployeeForm form) {

		// ログイン情報を検索する
		CmsEmployeeBean bean = new CmsEmployeeBean();
		
		String maxId = mapper.selectMaxId();
		String employeeId=String.valueOf(Integer.valueOf(maxId) + 1);
		String Job;
		if("J4".equals(form.getJobType())){
			Job="0";
		}else {
			Job="1";
		}
		DepartmentBean depBean =new DepartmentBean();
		String dep =form.getDepartmentName();
		depBean.setDepartmentId(dep);
		List<DepartmentBean> depList = generalMstMapper.selectDep(depBean);
		
		bean.setEmployeeId(employeeId); // 社員ID+1
		bean.setEmployeeName(form.getEmployeeName()); // 名前
		bean.setSex(form.getSelectedSexy()); // 性別
		bean.setBirthday(form.getBirthday()); // 生年月日
		bean.setAddress(form.getAddress()); // 住所
		bean.setPhone(form.getPhone()); // 携帯
		bean.setJoiningDate(form.getJoiningDate()); // 入社年月日
		bean.setMail(form.getMail()); // メール
		bean.setJobType(form.getJobType()); // 職種
		bean.setJobStatus("0");
		bean.setDelFlg("0");
		bean.setDepartmentName(depList.get(0).getDepartmentName()); //部門名
		bean.setDepartmentID(depList.get(0).getDepartmentId());	//部門ID
		bean.setCompanyID(form.getCompanyID());
		bean.setLoginId(employeeId); // ログインID
		bean.setPassword(employeeId); // パスワード
		bean.setPermissonID(Job);
		mapper.insert(bean);
		
		return form;
	}


	/**
	 * ユーザー情報検索 @param userSearchRequest リクエストデータ
	 * 
	 * @return 検索結果
	 */
	public CmsEmployeeForm editInit(CmsEmployeeForm form) {

		// ログイン情報を検索する
		CmsEmployeeBean sqlBean = new CmsEmployeeBean();
		sqlBean.setEmployeeId(form.getEmployeeId());
		
		List<CmsEmployeeBean> searchResults = mapper.select(sqlBean);
		if (!CollectionUtils.isEmpty(searchResults)) {
			CmsEmployeeBean result = searchResults.get(0);
			
			form.setEmployeeId(result.getEmployeeId()); // 社員ID
			form.setEmployeeName(result.getEmployeeName()); // 名前
			form.setSelectedSexy(result.getSex()); // 性別
			form.setMail(result.getMail()); // メール
			form.setBirthday(result.getBirthday().toString());    // 生年月日
			form.setPhone(result.getPhone()); // 携帯
			form.setAddress(result.getAddress()); // 住所
			form.setDepartmentName(result.getDepartmentName());	//部門名
			form.setCompanyName(result.getCompanyName());	//会社名
			form.setCompanyID("0001");	//会社ID
			form.setJobType(result.getJobType()); // 職種
			form.setJoiningDate(result.getJoiningDate().toString()); // 入社年月日
			form.setU_name(result.getU_name());		//緊急連絡人
			form.setRelationship(result.getRelationship());		//銘柄
			form.setU_address(result.getU_address());	//緊急連絡住所
			form.setU_phone(result.getU_phone());		//緊急連絡電話
			}

		return form;
	}
	

	/**
	 * 社員情報を更新する
	 * 
	 * @param form 社員フォーム
	 */
	public void update(CmsEmployeeForm form) {
		// 画面から社員IDを取得する
		String employeeId = form.getEmployeeId();
		// ログイン情報を検索する
		CmsEmployeeBean bean = new CmsEmployeeBean();
		bean.setEmployeeId(employeeId);

		List<CmsEmployeeBean> employeeList = mapper.select(bean);
		CmsEmployeeBean updateBean = employeeList.get(0);
		
		DepartmentBean dep = new DepartmentBean();
		String depString = form.getDepartmentName();
		dep.setDepartmentName(depString);
		List<DepartmentBean> ret = generalMstMapper.selectDep(dep);
		
		updateBean.setEmployeeName(form.getEmployeeName()); // 名前
		updateBean.setSex(form.getSelectedSexy()); // 性別
		updateBean.setMail(form.getMail()); // メール
		updateBean.setBirthday(form.getBirthday()); // 生年月日
		updateBean.setPhone(form.getPhone()); // 携帯
		updateBean.setAddress(form.getAddress()); // 住所
		updateBean.setDepartmentID(ret.get(0).getDepartmentId());	//部門ID
		updateBean.setDepartmentName(ret.get(0).getDepartmentName());	//部門名
		updateBean.setCompanyID(form.getCompanyID());		//会社ID
		updateBean.setCompanyName(form.getCompanyName());		//会社名
		updateBean.setJobType(form.getJobType()); // 職種
		updateBean.setJoiningDate(form.getJoiningDate());// 入社年月日
		updateBean.setU_name(form.getU_name());	//緊急連絡人
		updateBean.setRelationship(form.getRelationship()); //銘柄
		updateBean.setU_address(form.getU_address());	//緊急連絡住所
		updateBean.setU_phone(form.getU_phone());	//緊急連絡電話
		
		mapper.update(updateBean);
	}
	

	/**
	 * 社員情報を初期化する
	 * 
	 * @param form 社員フォーム
	 * @return 社員フォーム
	 */
	public CmsEmployeeForm readInit(CmsEmployeeForm form) {
//
		CmsEmployeeBean sqlBean = new CmsEmployeeBean();
		sqlBean.setEmployeeId(form.getEmployeeId());
		
		List<CmsEmployeeBean> searchResults = mapper.select(sqlBean);
		if (!CollectionUtils.isEmpty(searchResults)) {
			CmsEmployeeBean result = searchResults.get(0);
			
			form.setEmployeeId(result.getEmployeeId()); // 社員ID
			form.setEmployeeName(result.getEmployeeName()); // 名前
			form.setSelectedSexy(result.getSex()); // 性別
			form.setMail(result.getMail()); // メール
			form.setBirthday(result.getBirthday().toString());    // 生年月日
			form.setPhone(result.getPhone()); // 携帯
			form.setAddress(result.getAddress()); // 住所
			form.setDepartmentName(result.getDepartmentName());	//部門名
			form.setCompanyName(result.getCompanyName());	//会社名
			form.setCompanyID("0001");	//会社ID
			form.setJobType(result.getJobType()); // 職種
			form.setJoiningDate(result.getJoiningDate().toString()); // 入社年月日
			form.setU_name(result.getU_name());		//緊急連絡人
			form.setRelationship(result.getRelationship());		//銘柄
			form.setU_address(result.getU_address());	//緊急連絡住所
			form.setU_phone(result.getU_phone());		//緊急連絡電話
			

		}
		return form;
	}
	
	/**
	 * ユーザー情報を削除する
	 * 
	 * @param form フォーム
	 * @return 検索結果
	 */
	public CmsEmployeeListForm delete(CmsEmployeeListForm form) {

		//楽観チェックを行う
		optimismCheck(form);
		
		//社員ID
		String[] param = form.getSelectedItemId().split("_");
		String employeeId = param[0];
		
		CmsEmployeeBean deleteBean = new CmsEmployeeBean();
		deleteBean.setEmployeeId(employeeId);
		mapper.delete(deleteBean);
		
		return form;
	}
	
	/**
	 * ユーザー情報を削除する
	 * 
	 * @param form フォーム
	 * @return 検索結果
	 */
	public CmsEmployeeListForm deleteAll(CmsEmployeeListForm form) {
		
		String[] delIds = form.getSelectedItemIds().split(",");
		mapper.deleteAll(delIds);
		

		return form;
	}
	

	
	/**
	 * 楽観チェック
	 * 
	 * @param form フォーム
	 * 
	 * @return 検索結果
	 */
	public CmsEmployeeListForm optimismCheck(CmsEmployeeListForm form) {
		
		boolean btnFlg = form.isBtnFlg();
		
		String[] param = form.getSelectedItemId().split("_");

		//社員ID
		String employeeId = param[0];
		//最終更新日
		String updDateTime = param[1];
		
		//社員存在チェック
		CmsEmployeeBean sellectBean = new CmsEmployeeBean();
		sellectBean.setEmployeeId(employeeId);
		Integer employeeCount = mapper.selectRecordCount(sellectBean);
		if (employeeCount == 0) {
			throw new BusinessException(MessageConst.NOT_EXIST_CHECK);
		}
		//楽観チェック
		sellectBean.setUpdateDay(updDateTime);
		employeeCount = mapper.selectRecordCount(sellectBean);

		if (btnFlg && employeeCount == 0) {
			//編集ボタンOr削除ボタンを押下、レコードがほかの担当者に変更される場合
			throw new BusinessException(MessageConst.RECORD_IS_CHANGED);
		}
		return form;
	}
}