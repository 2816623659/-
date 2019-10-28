package com.dzkj.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.mapper.usermapper;
import com.dzkj.pojo.users;
import com.dzkj.service.userDaoImp;

@Controller
@RequestMapping("home")
public class IndexController {
	@Autowired
	userDaoImp userdao;

	@RequestMapping("index")
	public String index() {
		return "person/index";
	}

	// 个人信息跳转显示
	@RequestMapping("information")
	public String information() {
		return "person/information";
	}

	// 跳转安全设置
	@RequestMapping("safety")
	public String safety() {
		return "person/safety";
	}

	// 跳转更改密码页面
	@RequestMapping("password")
	public String password() {
		return "person/password";
	}

	// 修改密码
	@RequestMapping("updatepwd")
	@ResponseBody
	public String updatepwd(String userid, String useroldpassword, String usernewpassword) {
		users user = new users();
		user.setUserid(Integer.parseInt(userid));
		user.setPwd(useroldpassword);
		if (userdao.updatepwd(user) != null) {
			userdao.updatepassword(Integer.parseInt(userid), usernewpassword);
			return "updatesuccess";
		}
		return "erroruseroldpassword";
	}

	// 跳转支付密码页面
	@RequestMapping("setpay")
	public String setpay() {
		return "person/setpay";
	}

	// 修改支付密码验证
	String codestr = "", fristphone = "";

	@RequestMapping("tellpay")
	@ResponseBody
	public String tellpay(String phone) {
		String codeString = SendSmsUtil.sendCheckMSM(phone);
		codestr = codeString;
		fristphone = phone;
		return codestr;
	}

	// 设置或修改支付密码成功
	@RequestMapping("upay")
	@ResponseBody
	public String tellphone(String userid, String code, String paypwd) {
		if (codestr.equals(code)) {
			userdao.updatepay(Integer.parseInt(userid), paypwd);
			return "success";
		}
		return "error";
	}

	// 设置密码成功跳home.html页面
	@RequestMapping("setpaysuccess")
	public String setpaysuccess() {
		return "home/home";
	}

	// 跳转bindphone.html页面
	@RequestMapping("bindphone")
	public String bindphone() {
		return "person/bindphone";
	}

	// 修改手机号码验证
	String fristtellcodestr = "";

	@RequestMapping("phoneone")
	@ResponseBody
	public String tellphone(String phone) {
		String codeString = SendSmsUtil.sendCheckMSM(phone);
		fristtellcodestr = codeString;
		return fristtellcodestr;
	}

	String lasttellcodestr = "";

	@RequestMapping("phonetwo")
	@ResponseBody
	public String lastphone(String phone) {
		String codeString = SendSmsUtil.sendCheckMSM(phone);
		lasttellcodestr = codeString;
		return lasttellcodestr;
	}

	// 设置手机号码成功
	@RequestMapping("uphone")
	@ResponseBody
	public String utellphone(String userid,String code, String newcode, String newphone) {
		if (code.equals(fristtellcodestr) && newcode.equals(lasttellcodestr)) {
			userdao.updatephone(Integer.parseInt(userid),newphone);
			return "success";
		}
		return "error";
	}
	//修改个人信息
	@RequestMapping("upduser")
	public String upateuser(String userid, String uzname, String nikname,String usex, String birthday,String tellphone,String email) {
		System.out.println("id"+userid);
		System.out.println("昵称"+uzname);
		System.out.println("姓名"+nikname);
		System.out.println("性别"+usex);
		System.out.println("生日"+birthday);
		System.out.println("电话号码"+tellphone);
		System.out.println("电子邮件"+email);
		userdao.updateusers(Integer.parseInt(userid), uzname, nikname, usex, birthday, tellphone,email);
		return "person/index";
	}
}
