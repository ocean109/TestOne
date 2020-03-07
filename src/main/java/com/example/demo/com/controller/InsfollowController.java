package com.example.demo.com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.pojo.InsFollow;
import com.example.demo.com.service.InsFollowMapperService;

@Controller
@RequestMapping("insFollowController")
public class InsfollowController {
	@Resource
	private InsFollowMapperService insFollowMapperService;
	

	
	@RequestMapping(value="/insertInsfollow")
	@ResponseBody
	public String insertInsfollow(InsFollow insFollow) {
		boolean b = insFollowMapperService.insertInsFollow(insFollow);
		String json = JSONObject.toJSONString(b);
		System.out.println("insertInsfollow b="+b);
		return json;
	}
}
