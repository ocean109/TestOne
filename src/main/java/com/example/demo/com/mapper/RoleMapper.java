package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.com.pojo.Role;

@Mapper
public interface RoleMapper {
	//加载所有的角色
	public List<Role> selectRole();
	//把角色id和角色对应树结构的id 存入rolemenu表中
	public int insertRole(String menuNums,int idd);
	//添加角色
	public int addRole(@Param("rname")String rname,@Param("level")String level,@Param("remark")String remark);
	//删除角色
	public int delete(@Param("id")String id);
}
