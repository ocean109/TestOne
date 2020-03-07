package com.example.demo.com.service;

import java.util.List;

import com.example.demo.com.pojo.Role;
import com.example.demo.com.pojo.RoleMenu;

public interface RoleService {
	//加载所有的角色属性
	public List<Role> selectAll();
	//把角色id和角色对应树结构的id 存入rolemenu表中
	public boolean insert(String menuNums,int idd);
	//查看角色的id是否有与之对应的树结构
	public boolean select(int idd);
	//删除对应id的树结构
	public boolean delete(int idd);
	//查出对应idd的树结构
	public List<RoleMenu> selectIdd(int idd);
	//添加角色
	public boolean addRole(String rname,String level,String remark);
	//删除角色
	public boolean deleteRole(String id);
	

}
