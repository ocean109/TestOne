package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.com.pojo.User;

@Mapper  //代替了之前扫描接口的操作
public interface UserMapper {
	
	//判断是否有这个用户
	public int selectUser(@Param("userName")String userName);
	//查询所有用户
	public List<User> selectUserAll();
	//修改密码啊啊啊 
	public int updataUser(@Param("userName")String userName,@Param("pwd")String pwd,@Param("pwdj")String pwdj);
	//判断登陆的账号 密码  级别
	public User selectU(@Param("userName")String userName,@Param("pwd")String pwd);
	//添加员工
	public int adduser(User user);
	//为删除
	public int daletUser(int id);
	//异步查询员工编号
	public int selectid(int rid);
	//异步重置密码
	public int uppwd (int id);
	//查询所有的保险员工
	public List<User> selectUserRole();
}
