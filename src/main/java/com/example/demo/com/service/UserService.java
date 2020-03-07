package com.example.demo.com.service;

import java.util.List;

import com.example.demo.com.pojo.User;

public interface UserService {
	
	//判断此用户名是否存在
	public boolean selectUser(String userName);
	//遍历所有的用户
	public List<User> selectUserAll();
	//修改用户密码
	public int updataUser(String userName,String pwd,String pwdj);
	//判断账号和密码  并且返回这个用户
	public User select(String userName,String pwd); 
	//添加员工
	public boolean adduser(User user);
	//为删除
	public boolean daletUser(int i);
	//异步查编号
	public boolean selectRid(int rid);
	//异步重密码
	public boolean uppwd(int id);
	//查询所有的保险员工
	public List<User> selectUserRole();
}
