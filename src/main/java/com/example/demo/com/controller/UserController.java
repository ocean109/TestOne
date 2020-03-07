package com.example.demo.com.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.pojo.FreeIns;
import com.example.demo.com.pojo.PageBean;
import com.example.demo.com.pojo.User;
import com.example.demo.com.service.MenuUtilService;
import com.example.demo.com.service.UserService;

@Controller
@RequestMapping("UserController")
//判断账号密码 和级别
public class UserController {

	@Resource
	private MenuUtilService menuUtilService;
	@Resource
	private UserService userService;
	//查询所有的保险员工
	@RequestMapping(value="selectUserRole")
	@ResponseBody
	public String selectUserRole() {
		
		List<User> list = userService.selectUserRole();
		
		String json = JSONObject.toJSONString(list);
		System.out.println(json);
		return json;
	}
	//退出系统
	@RequestMapping(value="/exit")
	public void exit(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		//消除session
		session.invalidate();//session失效
		//并且跳转回登陆页面
		try {
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
		} catch (IOException e) {
			System.out.println("转跳失败!");
			e.printStackTrace();
		}
		
	}
	
	//异步重置密码
	@RequestMapping(value="/upwpd")
	@ResponseBody
	public String upwpd(int id) {
		System.out.println("----异步"+id);
		boolean b = userService.uppwd(id);
		String json = JSONObject.toJSONString(b);
		System.out.println("异步修改密码-----"+json);
		return json;
	}
	

	
	// 查员工编号是否重复
	@RequestMapping(value = "/selectRid")
	@ResponseBody
	public String selectRid(String rid) {
		int r = Integer.parseInt(rid);
		System.out.println("-----"+r);
		boolean b = userService.selectRid(r);
		String json = JSONObject.toJSONString(b);
		System.out.println(json);
		return json;
	}

	// 删除员工(伪删除 状态改为0)
	@RequestMapping(value = "/deletUser")
	@ResponseBody
	public String deletUser(int level) {
		boolean b = userService.daletUser(level);
	
		String json = JSONObject.toJSONString(b);
		System.out.println(b);
		return json;
	}

	// 添加员工
	@RequestMapping(value = "/addUser")
	public String addUser(String userName,String rid,String level,String remark) {
		System.out.println("--------------------");
		String s = null;
		User user = new User();
		user.setUserName(userName);
		int r = Integer.parseInt(rid);
		user.setRid(r);
		int l = Integer.parseInt(level);
		user.setLevel(l);
		user.setRemark(remark);
		System.out.println("-----" + user);
		//查看添加的用户是否重复
		boolean b=userService.selectUser(user.getUserName());
		
		//查看添加用户的id是否重复
		if(b) {
			b = userService.selectRid(user.getRid());
		
			if(b) {
				System.out.println("user:"+user);
				  b= userService.adduser(user);
				  System.out.println("3"+b);
				  if(b) {
						s = "/user/userManager";
				  }else {
					  s = "/user/adduser"; 
				  }
			}
		  
		}else {
			s = "/user/adduser";
		}
		System.out.println(s);
		return s;
	}

	// 查询所有的用户的信息
	@RequestMapping(value = "/selectAll")
	@ResponseBody
	public String selectAll() {
		PageBean pb = new PageBean();
		List<User> userList = userService.selectUserAll();
		pb.setRows(userList);
		pb.setTotal(userList.size());
		String json = JSONObject.toJSONString(pb);
		System.out.println(pb);

		return json;
	}
	@RequestMapping(value = "/tsest")
	public void test(FreeIns freeIns) {
		System.out.println("--------------------------"+freeIns);
	}

	// 判断用户是否存在 并且是否离职
	@RequestMapping(value = "/User")
	@ResponseBody
	public String userLogin(String userName, String pwd, HttpServletRequest request, HttpServletResponse response) {

		User use = userService.select(userName, pwd);
		boolean b = false;
		if(use!=null) {
			if (use.getIsdel() == 1) {
				b = true;
				HttpSession session = request.getSession();
				session.setAttribute("userId", use.getId());
				session.setAttribute("remark", use.getRemark());
				session.setAttribute("pwd", use.getPwd());
				session.setAttribute("rid",use.getRid());
			}
		}
	
		

		String json = JSONObject.toJSONString(b);
		System.out.println(json);
		return json;
	}

}
