package com.cms.sample.form.cmsemployee;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.cms.base.form.BaseForm;
import com.cms.sample.entity.employee.CmsEmployeeBean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報 検索用リクエストデータ
 */
@Getter
@Setter
@Data
public class CmsEmployeeForm extends BaseForm {

	/* 検索結果 */
	private List<CmsEmployeeBean> results1;

	private String employeeId;

	@NotEmpty
	@Length(max=8)
	private String employeeName;
	
	private String type;

	//職種選択リスト
	@NotEmpty
	private String jobType;
	private Map<String, String> jobTypeList;

	//性別選択リスト
	@NotEmpty
	private String selectedSexy;
	private Map<String, String> sexyList;
	
	@NotEmpty
	private String birthday;

	@NotEmpty
	@Length(max=50)
	private String address;
	
	//電話番号チェック
	@Pattern(regexp = "0\\d{1,3}\\d{1,4}\\d{4}", message = "電話番号の形式で入力してください(99999999999)")
	private String phone;

	@NotEmpty
	private String joiningDate;

	@Email
	@Length(max=100)
	private String mail;

	//部門名
	@NotEmpty
	private String departmentName;
	private Map<String, String> departmentList;
	
	//部門Id
	private String departmentID;
	
	//所属会社
	private String companyName;
	private String companyID;
	
	
	private Date registrationDate;
	private Date updateDate;
	
	//緊急連絡先一覧
	private String u_name;
	
	private String u_address;
	
	private String u_phone;
	
	private String relationship;

	
}