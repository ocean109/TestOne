package com.example.demo.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.UserMapper;
import com.example.demo.com.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	//判断此用户名是否存在
	@Override
	public boolean selectUser(String userName) {
	
		int i  = userMapper.selectUser(userName);
	System.out.println("``"+i);
		return i>0?false:true;
	}

	//遍历所有的用户
	public List<User> selectUserAll() {
		List<User> userList = new ArrayList<User>();
		userList=userMapper.selectUserAll();
		return userList;
	}

	//用户密码
	public int updataUser(String userName, String pwd,String pwdj) {
		int i = userMapper.updataUser(userName, pwd,pwdj);
		return i;
	}

	//判断账号密码是否正确
	public User select(String userName, String pwd) {
		User use = userMapper.selectU(userName,pwd);
		return use;
	}

	//添加员工
	public boolean adduser(User user) {
		boolean b=false;
		int i = userMapper.adduser(user);
		if(i>0) {
			b=true;
		}
		return b;
	}

	//为删除
	public boolean daletUser(int i) {
		System.out.println("UserServiceImpl :"+i);
		int d = userMapper.daletUser(i);
		System.out.println(d);
		boolean c = false;
		if(d>0) {
			c=true;
		}
		return c;
	}

	//异步查编号
	public boolean selectRid(int rid) {
		System.out.println("####"+rid);
		int i = userMapper.selectid(rid);
		System.out.println("异步查编号+++:"+i);
		return i>0?false:true;
	}

	//异步重置密码
	public boolean uppwd(int id) {
		int i=userMapper.uppwd(id);
		return i>0?true:false;
	}

	//查询所有的保险员工
	public List<User> selectUserRole() {
	List<User> list = userMapper.selectUserRole();
		return list;
	}
}
