package com.dzkj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.dzkj.pojo.users;

import tk.mybatis.mapper.common.Mapper;

public interface usermapper extends  Mapper<users>{
	//手机号注册
		Integer inserttell(@Param("tellphone") String tellphone, @Param("pwd") String pwd,@Param("time") String time);
	//登录查询
	users login(users user);
	//修改确认原密码正确
	users updatepwd(users user);
	//确认修改密码，修改成功
	Integer updatepassword(@Param("userid") int userid, @Param("usernewpassword") String usernewpassword);
	//修改支付密码
	Integer updatepay(@Param("userid") int userid, @Param("paypwd") String paypwd);
	//修改手机号码
	Integer updatephone(@Param("userid") int userid, @Param("tellphone") String tellphone);
	//修改个人信息
	Integer updateusers(@Param("userid") Integer userid, @Param("uzname") String uzname, @Param("nikname") String nikname, @Param("usex") String usex,@Param("birthday") String birthday,@Param("tellphone") String tellphone,@Param("email") String email);
}
