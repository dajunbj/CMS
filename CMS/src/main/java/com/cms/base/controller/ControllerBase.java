package com.cms.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.base.entity.DepartmentBean;
import com.cms.sample.entity.company.CmsCompanyBean;
import com.cms.sample.entity.employee.CmsEmployeeBean;
import com.cms.sample.form.cmsemployee.CmsEmployeeForm;
import com.cms.sample.form.cmsemployee.CmsEmployeeListForm;
import com.cms.sample.service.model.CmsSelectEmployeeService;
import com.utils.DepartmentUtils;
import com.utils.ServiceUtils;

/**
 * 新規コントローラ
 */
@Component
public class ControllerBase {

	@Autowired
	CmsSelectEmployeeService employeeService;
	
	@Autowired
	ServiceUtils serviceUtils;
	
	@Autowired
	DepartmentUtils department;
	
	
	
	
	/**
	 * メニューをクリックする
	 */
	@RequestMapping(value = "", params = "transitionTo", method = RequestMethod.POST)
	public String transitionTo(Model model, @RequestParam String transitionTo) {
		// 画面データ初期化
		return "redirect:" + transitionTo;
	}

	/**
	 * 共通項目設定(編集画面)
	 * 
	 * @param form    社員編集画面フォーム
	 * @param initFlg 画面初期化フラグ
	 * @throws SystemException 
	 */
	public void setCommonItem(CmsEmployeeForm form, boolean initFlg) {

		try {
			// 選択リスト{EMPLOYEE_TYPE:社員種別}
//			form.setEmployeeKbnMap(serviceUtils.getGeneralMastInfo("EMPLOYEE_KBN"));
	
			// 選択リスト{SEXY:性別}
			form.setSexyList(serviceUtils.getGeneralMastInfo("SEXY"));
	
			//選択リスト{JOB_TYPE:職種}
			form.setJobTypeList(serviceUtils.getGeneralMastInfo("JOB_TYPE"));
			
			if (initFlg) {
				form.setSelectedSexy("0");
				form.setJobType("J4");
			}
			
			//部門テーブルから、部門名を取り出す
			List<DepartmentBean> result = department.getGeneralMastInfo("");
			Map<String, String> dep =new HashMap<String, String>();
			for (DepartmentBean bean : result) {
				dep.put(bean.getDepartmentId(), bean.getDepartmentName());
			}
			form.setDepartmentList(dep);
			
		} catch (SystemException se) {
			System.out.println(se.getMessage());
		}
	}

	/**
	 * 共通項目設定(一覧画面)
	 * 
	 * @param form    社員編集画面フォーム
	 * @param initFlg 初期化フラグ
	 * @throws SystemException 
	 */
	public void setCommonItem(CmsEmployeeListForm form, boolean initFlg) throws SystemException  {

		Map<String, String> sexMap = serviceUtils.getGeneralMastInfo("SEXY");
		sexMap.put("2", "すべて");
		// 選択リスト{SEXY:性別}
		form.setSexyList(sexMap);
		if (initFlg) {
			form.setSelectedSexy("2");
		}

		// 選択リスト{JOB_TYPE:職種}
//		form.setJobTypeList(serviceUtils.getGeneralMastInfo("JOB_TYPE"));
//		if (initFlg) {
//			form.setSelectedJobType("J5");
//		}
		//部門テーブルから、部門名を取り出す
		List<DepartmentBean> result = department.getGeneralMastInfo("");
		Map<String, String> dep =new HashMap<String, String>();
		for (DepartmentBean bean : result) {
			dep.put(bean.getDepartmentId(), bean.getDepartmentName());
		}
		form.setDepartmentList(dep);
	}

	// ----------PopUp画面（会社名+社員名選択画面）・検索ボタン start----------

	@PostMapping(value = "/searchEmployees")
	@ResponseBody
	public List<CmsEmployeeBean> searchEmployees(@RequestParam Map<String, Object> params) {

		CmsEmployeeBean bean = new CmsEmployeeBean();
		bean.setEmployeeName(params.get("name").toString());
		List<CmsEmployeeBean> result = employeeService.select(bean);

		return result;
	}
	// ----------PopUp画面（会社名+社員名選択画面）・検索ボタン end ----------
	
	
	// ----------PopUp画面（会社名+会社ID選択画面）・検索ボタン start----------
	@PostMapping(value = "/searchCompany")
	@ResponseBody
	public List<CmsCompanyBean> searchCompany(@RequestParam Map<String, Object> params) {
		
		CmsCompanyBean bean = new CmsCompanyBean();
		String str = params.get("name").toString();
		bean.setCompanyName(str);
		List<CmsCompanyBean> result = employeeService.selectCoapany(bean);
		
		return result;
	}
	// ----------PopUp画面（会社名+会社ID選択画面）・検索ボタン end ----------
}