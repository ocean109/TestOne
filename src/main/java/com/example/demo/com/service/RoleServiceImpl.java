package com.example.demo.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.RoleMapper;
import com.example.demo.com.mapper.RoleMenuMapper;
import com.example.demo.com.pojo.Role;
import com.example.demo.com.pojo.RoleMenu;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleMenuMapper roleMenuMapper;
	//加载所有的角色
	public List<Role> selectAll() {
		List<Role> roleList= roleMapper.selectRole();
		
		return roleList;
	}
	//把角色id和角色对应树结构的id 存入rolemenu表中
	public boolean insert(String menuNums, int idd) {
		boolean b= true;
	
	
		if(menuNums!=null) {
			//	menuNums 拿过来是一个 字符串带逗号的字符串  这里要做一下字符串分割变数组
			String[] menuNumArr = menuNums.split(",");
	
			//遍历树结构数组menuNumArr把它存到rolemenu表中
			for (String string : menuNumArr) {
				if(b) {
					b=roleMenuMapper.insert(string,idd);
				}else {
					b= false;
				}
			
			}
		
		}
		
		return b;
	}
	//查看角色的id是否有与之对应的树结构
	public boolean select(int idd) {
		int i = roleMenuMapper.select(idd);
	
		return i>0?true:false;
	}
	//删除对应id的树结构
	public boolean delete(int idd) {
		int i = roleMenuMapper.delete(idd);
		return i>0?true:false;
	}
	//查出对应idd的树结构
	public List<RoleMenu> selectIdd(int idd) {
		List<RoleMenu> roleMenuList = roleMenuMapper.selectIdd(idd);
		return roleMenuList;
	}
	//添加角色
	public boolean addRole(String rname, String level, String remark) {
	
		int i = roleMapper.addRole(rname, level, remark);
		
		return i>0?true:false;
	}
	//删除角色
	public boolean deleteRole(String id) {
		int i = roleMapper.delete(id);
		return i>0?true:false;
	}
	

}
