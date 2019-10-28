package com.dzkj.service;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.users;

public interface userDaoImp {
	
	//登录查询
	users login(users user);
	//修改确认原密码正确
	users updatepwd(users user);
	//修改原密码成功
	Integer updatepassword(int userid,String usernewpassword);
	//修改支付密码
	Integer updatepay(int userid,String paypwd);
	//修改手机号码
	Integer updatephone(int userid, String tellphone);
	//手机号注册
	Integer inserttell(String tellphone,String pwd,String time);
	//修改个人信息
	Integer updateusers( int userid, String uzname, String nikname,String usex, String birthday,String tellphone,String email);
}
