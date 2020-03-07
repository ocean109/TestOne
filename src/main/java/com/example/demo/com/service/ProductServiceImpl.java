package com.example.demo.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.ProductMapper;
import com.example.demo.com.pojo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;
	
	//查询所有的保险项目
	public List<Product> selectAll() {
		List<Product> list = productMapper.selectAll();
		return list;
	}

}
