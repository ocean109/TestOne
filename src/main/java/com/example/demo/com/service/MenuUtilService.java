package com.example.demo.com.service;

import java.util.List;

import com.example.demo.com.pojo.MenuUtil;

public interface MenuUtilService {
	//按menuNum查询对应树结构
	public MenuUtil select(String menuNum);
	//查找全部树结构
	public List<MenuUtil> selectAll();

}
