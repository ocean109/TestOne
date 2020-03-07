package com.example.demo.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.MenuUtilMapper;
import com.example.demo.com.pojo.MenuUtil;

@Service
public class MenuUtilServiceImpl implements MenuUtilService {
	
	@Resource
	private MenuUtilMapper menuUtilMapper;
	
	@Override
	public MenuUtil select(String menuNum) {
		MenuUtil menuUtil = new MenuUtil();
		menuUtil = menuUtilMapper.selectMenuutil(menuNum);
		return menuUtil;
	}

	@Override
	public List<MenuUtil> selectAll() {
		List<MenuUtil> menuUtilList = menuUtilMapper.selectAll();
		return menuUtilList;
	}

}
