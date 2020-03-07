package com.example.demo.com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.pojo.Role;
import com.example.demo.com.service.RoleService;

@Controller
@RequestMapping("RoleController")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	@RequestMapping(value="/delete")
	@ResponseBody
	public String delete(String id) {
		boolean b = roleService.deleteRole(id);
		String json=JSONObject.toJSONString(b);
		System.out.println("......."+b);
		return json;
	}
	//添加角色
	@RequestMapping(value="/addRole")
	@ResponseBody
	public String addRole(String rname,String level,String remark) {
		boolean b = roleService.addRole(rname, level, remark);
		System.out.println("--"+b);
		String json = JSONObject.toJSONString(b);
		System.out.println("//"+json);
		return json;
	}
	//查询所有角色信息
	@RequestMapping(value="/selectAll")
	@ResponseBody
	public String selectAll() {
		List<Role> role = roleService.selectAll();
		String json = JSONObject.toJSONString(role);
		System.out.println(json);
		return json;
	}
	//存储对应角色的树结构
	@RequestMapping(value="/inserRole")
	@ResponseBody
	public String inserRole(String menuNums,int idd) {
	
		System.out.println("-*-*"+menuNums);
		
		System.out.println("*-*-"+idd);
		//存储的时候先判断看之前有没有存过对应id的目录树结构 
		boolean b = roleService.select(idd);
		System.out.println("111"+b);
		if(b) {
			//有的话删除后再存储  
			b= roleService.delete(idd);
			System.out.println("222"+b);
			if(b) {
			b=roleService.insert(menuNums, idd);
			System.out.println("333"+b);
			}else {
				System.out.println("删除失败！");
			}
		} else {
			b=roleService.insert(menuNums, idd);
			System.out.println("444"+b);
		}
		String json = JSONObject.toJSONString(b);
		System.out.println("444"+json);
		return json;
	}

}
