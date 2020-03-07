package com.example.demo.com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.pojo.Product;
import com.example.demo.com.service.ProductService;

@Controller
@RequestMapping("ProductController")
public class ProductController {
	@Resource
	private ProductService productService;
	
	//查询所有的保险项目
	@RequestMapping(value="/selectAll")
	@ResponseBody
	private String selectAll() {
		System.out.println("--");
		List<Product> list = productService.selectAll();
		String json = JSONObject.toJSONString(list);
		System.out.println("selectAll  list:"+list);
		return json;
	}

}
