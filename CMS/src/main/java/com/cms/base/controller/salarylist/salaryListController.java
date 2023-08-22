package com.cms.base.controller.salarylist;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.base.controller.ControllerBase;
import com.cms.base.form.salary.salaryListForm;
import com.cms.base.service.salaryService;
import com.cms.common.CommonMapper;
import com.utils.ServiceUtils;

//import java.util.List;

/**
 * ログイン コントローラー
 */
@Controller
@RequestMapping(value = "/cmsSalary/salarylist")
//ControllerBase 自定义的基类或者说抽象类，用于扩展和提供通用的功能给其他控制器类。
public class salaryListController extends ControllerBase {
	//private List<salaryResultBean> lst = new ArrayList<>();


	@Autowired
	salaryService service;

	@Autowired
	ServiceUtils serviceUtils;
	
	@Autowired
	CommonMapper commonMapper;

	/**
	 * ユーザ画面初期化
	 */
	//指定该方法处理的是 HTTP GET 请求。
	@RequestMapping(method = RequestMethod.GET)
	//接收M和H对象作为参数 并返回string类型
	public String init(Model model, HttpServletRequest request) {

		
			//：创建一个 MarketStoreListForm 对象，用于初始化用户界面。
			salaryListForm form = new salaryListForm();
			
			//form.setAddress("北海道");定义初始值
			//form.setStoreName("王の店");
			
			//将form的值返回给model
			//把新new的form放入model里 并命名为"form"(表单)
			model.addAttribute("form", form);
			
			return "/cmsSalary/salarylist";
	}

//	/**
//	 * 检索按钮  初始化菜单页面
//	 */
//	//这是一个请求映射注解，指定了当请求参数为 "select" 且请求方法为 POST 时，执行该方法。
//	@RequestMapping(params = "select", method = RequestMethod.POST)
//	
//	public String select(@ModelAttribute("form") salaryListForm form, Model model, HttpServletRequest request) {
//		try {
//			
//			service.select(form);
//		} catch (BusinessException be) {
//			
//			//業務エラーを画面に表示する
//			form.setErrorMessage(be.getMessage());
//			model.addAttribute("form", form);
//		}
//		return "/marketstore/MarketStorelist";
//	}
//	
//	/**
//	 * 新規ボタン
//	 */
//	//params属性可以接受一个字符串数组，用于指定参数的要求
//	@RequestMapping(params = "addStore", method = RequestMethod.POST)
//	public String addStore(Model model) {
//
//		return "redirect:/marketstore/MarketStoreadd";
//	}
//	
//	/**
//	 * 参照ボタン
//	 */
//	//使用@RequestMapping映射请求的方法
//	
//		//method 这个部分表示该方法仅处理HTTP发来的方法为POST的请求。
//	@RequestMapping(params = "read", method = RequestMethod.POST)
//	
//	
//	//RedirectAttributes redirectAttributes：这是一个用于在重定向时传递属性的对象。
//	//它可以用于在重定向之间传递数据，例如将数据传递给下一个请求或将数据作为 URL 参数传递。
//	//read是传递来的参数的值
//	
//	public String read(@ModelAttribute("form") salaryListForm form, 
//			Model model, RedirectAttributes redirectAttributes, @RequestParam String read) {
//
//			String[] param = read.split("_");
//			try {
//			//BtnFlg 按钮状态或标识的变量名，它通常用于记录按钮的状态或标识是否被触发或设置。
//			form.setBtnFlg(true);
//			
//			} catch (BusinessException be) {
//			
//			form.setErrorMessage(be.getMessage());
//			// 调用 searchScreenList 方法对表单进行数据的初始化，
//			//将 form 和 model 传递给该方法，并返回视图路径 "/marketstore/MarketStorelist"。
//			searchScreenList(form, model);
//			return "/marketstore/MarketStorelist";
//			}
//
//		// 更新画面へ渡す引数：社員ＩＤ
//		redirectAttributes.addAttribute("selectedStoreId", param[0]);
//		return "redirect:/marketstore/MarketStoreview";
//
//	}
//		//它可能是用于在控制器中进行表单数据的初始化和查询操作的方法。
//		private void searchScreenList(salaryListForm form, Model model) {
//		// TODO 自動生成されたメソッド・スタブ
//		
//	}
//
//	/**
//	 * 更新ボタン
//	 */
//	@RequestMapping(params = "update", method = RequestMethod.POST)
//	public String update(RedirectAttributes redirectAttributes, @RequestParam String update) {
//        
//
//		// 更新画面へ渡す引数：社員ＩＤ
//		redirectAttributes.addAttribute("selectedStoreId",update);
//		return "redirect:/marketstore/MarketStoreedit";
//
//	}
//	
//	/**
//	 * 削除ボタン
//	 */
//	@RequestMapping(params = "delete", method = RequestMethod.POST)
//	public String delete(@ModelAttribute("form") salaryListForm form, 
//			Model model, @RequestParam String delete) {
//
//		try {
//			
//			//削除対象をサービスに渡す
//			//form.set(delete);
//			//削除を行う
//			service.delete(delete);
//
//			// 画面データ初期化
//			//searchScreenList(responseForm, model);
//		} catch (BusinessException be) {
//			
//			form.setErrorMessage(be.getMessage());
//			//削除が失敗したら、再検索をしなく、そのままエラー情報を画面に設定する
//			// 画面データ初期化
//			//searchScreenList(form, model);
//			model.addAttribute("form", form);
//		}
//
//		return "redirect:/marketstore/MarketStorelist";
//
//	}
//	/**
//	 * 全削除.该控制层方法接收一个POST请求，并通过调用服务层的方法执行全削除操作，
//	 * 并根据结果选择初始化数据或者将错误消息添加到模型中
//	 */
//	//使用@RequestMapping注解的方法，用于处理POST请求，并根据请求参数deleteAll来触发该方法
//	
//	//method 这个部分表示该方法仅处理HTTP发来的方法为POST的请求。
//	
//	@RequestMapping(params = "deleteAll", method = RequestMethod.POST)
//	//通过 @ModelAttribute 注解，将名为 "form" 的模型属性绑定到 MarketStoreListForm 对象上。
//	//这样，从前端传递的表单数据将自动填充到 form 对象中。
//	//MarketStoreListForm 类型的 form 参数上，并且将其命名为 "form"。
//	
//	public String deleteAll(@ModelAttribute("form") salaryListForm form, Model model) {
//		try {
//		//全削除サービスを呼び出す
//		service.deleteAll(form.getDeleteStoreIds());
//
//		// 重新获取画面数据进行初始化
//		//service.select(form);
//	} catch (BusinessException be) {
//			
//			form.setErrorMessage(be.getMessage());
//			
//			//addAttribute 方法用于向 Model 添加 "form"是属性名字,form的值进而展示到画面中
//			model.addAttribute("form", form);
//	}
//		return"/marketstore/MarketStorelist";
//
//	}
}