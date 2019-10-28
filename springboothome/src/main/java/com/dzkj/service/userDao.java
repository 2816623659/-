package com.dzkj.service;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dzkj.mapper.usermapper;
import com.dzkj.pojo.users;

import tk.mybatis.mapper.common.Mapper;

@Service
public class userDao implements userDaoImp{
	@Resource
	usermapper usermapper;
	//手机号注册
	@Override
	public Integer inserttell(String tellphone, String pwd,String time) {
		return usermapper.inserttell(tellphone, pwd,time);
	}
	//登录的实现
	@Override
	public users login(users user) {
		return usermapper.selectOne(user);
	}
	//修改确认原密码正确
	@Override
	public users updatepwd(users user) {
		return usermapper.selectOne(user);
	}
	//修改原密码成功
	@Override
	public Integer updatepassword(int userid, String usernewpassword) {
		return usermapper.updatepassword(userid, usernewpassword);
	}
	//修改支付密码
	@Override
	public Integer updatepay(int userid, String paypwd) {
		return usermapper.updatepay(userid, paypwd);
	}
	//修改手机号码
	@Override
	public Integer updatephone(int userid, String tellphone) {
		return usermapper.updatephone(userid, tellphone);
	}
	@Override
	//修改个人信息
	public Integer updateusers(int userid, String uzname, String nikname, String usex, String birthday,
			String tellphone,String email) {
		return usermapper.updateusers(userid, uzname, nikname, usex, birthday, tellphone,email);
	}
}
