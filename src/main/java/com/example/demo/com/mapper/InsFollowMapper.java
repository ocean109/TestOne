package com.example.demo.com.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.com.pojo.InsFollow;

@Mapper
public interface InsFollowMapper {
	//添加回访记录
	public int insertInsFollow(InsFollow insFollow);


}
