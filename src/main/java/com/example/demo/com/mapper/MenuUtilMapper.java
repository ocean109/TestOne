package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.com.pojo.MenuUtil;

@Mapper   //代替了之前扫描接口的操作
public interface MenuUtilMapper {
	
	//查询经理树结构内容
	public MenuUtil selectMenuutil(@Param("menuNum")String menuNum);
	//查找全部树结构
	public List<MenuUtil> selectAll();
	

}
