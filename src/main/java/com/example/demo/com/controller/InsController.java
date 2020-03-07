package com.example.demo.com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.pojo.Ins;
import com.example.demo.com.service.InsService;

@Controller
@RequestMapping("insController")
public class InsController {
	
	@Resource
	private InsService insService;
	//财务打回到经理那里 
	@RequestMapping(value="/updataInsStatuss")
	@ResponseBody
	public String updataInsStatuss(int id) {
	   boolean b  = insService.updataInsstatus(id);
		String json=JSONObject.toJSONString(b);
		System.out.println("updataInsStatus"+json);
		return json;
	}
	//财务查看经理确认后的所有人的保险人信息
	@RequestMapping(value="/selectInsAllzf")
	@ResponseBody
	public String selectInsAllzf() {
		List<Ins> list = insService.selectInsAllzf();
		String json=JSONObject.toJSONString(list);
		System.out.println("selectInsAllzf"+json);
		return json;
	}
	//经理打回给保险人员   改变状态
	@RequestMapping(value="/updataStatuszf")
	@ResponseBody
	public String updataStatuszf(int id) {
		boolean b = insService.updataInsStatus(id);
		String json = JSONObject.toJSONString(b);
		System.out.println(b);
		return json;
	}
	//经理确认后给财务   改变状态
	@RequestMapping(value="/status")
	@ResponseBody
	public String status(int id) {
		boolean b=insService.status(id);
		String json = JSONObject.toJSONString(b);
		return json;
	}
	//购买后提交给经理  改变状态?购买后确认后提交给财务
	@RequestMapping(value="/updataStatus")
	@ResponseBody
	public String updataStatus(int id) {
		boolean b = insService.updataStatus(id);
		String json = JSONObject.toJSONString(b);
		System.out.println("----- b:"+b);
		return json;
	}
	//购买保险 id1 客户id   id2 保险项目id
	@RequestMapping(value="/updateProduct")
	@ResponseBody  
	public String updateProduct(int id1,int id2) {
		boolean b =insService.updateProduct(id1, id2);
		String json = JSONObject.toJSONString(b);
		System.out.println("updateProduct  b:"+b);
		return json;
	}
	@RequestMapping(value="/updateInsfollow")
	@ResponseBody
	public String updateInsfollow(Ins ins) {
		System.out.println("/updateInsfollow  ins"+ins);
		boolean b = insService.updataIns(ins);
		String json=JSONObject.toJSONString(b);
		System.out.println("-*/*-/*-/*-/*"+b);
		return json;
	}
	//加载对应员工 客户的 保险信息
	@RequestMapping(value="/selectInsAll")
	@ResponseBody
	public String selectAll(HttpSession session) {
		int userId = (int)session.getAttribute("userId");
		List<Ins> list = insService.selectInsAll(userId);
		String json = JSONObject.toJSONString(list);
		System.out.println("selectInsAll :"+json);
		return json;
	}
	@RequestMapping(value="/addIns")
	@ResponseBody
	//id1 免险客户信息   id2 免险员工信息   
	/**
	 * 1.查询到免险客户信息   并且修改其状态 为0  也可以先修改然后查询 
	 * 2.保存到ins表里面
	 * 3.修改状态 和userId
	 */
	public String addIns(int id1,int id2) {
		System.out.println(id1+"---"+id2);  //1-----6
		boolean b = insService.addIntOne(id1, id2);
		String json=JSONObject.toJSONString(b);
		System.out.println(json);
		return json;
	}
	//经理确认保险
	@RequestMapping(value = "/selectInsAllw")
	@ResponseBody
	public String selectInsAllw() {
		List<Ins> list = insService.selectINS();
		String json =JSONObject.toJSONString(list);
		
		return json;
	}
}
