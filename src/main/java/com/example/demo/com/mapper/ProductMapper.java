package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.com.pojo.Product;

@Mapper
public interface ProductMapper {

	//查询所有的保险项目
	public List<Product> selectAll();
}
