package com.example.demo.com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.InsFollowMapper;
import com.example.demo.com.pojo.InsFollow;

@Service
public class InsFollowMapperServiceImpl implements InsFollowMapperService{

	@Resource
	private InsFollowMapper insFollowMapper;
	
	@Override
	public boolean insertInsFollow(InsFollow insFollow) {
		int i = insFollowMapper.insertInsFollow(insFollow);
		return i>0?true:false;
	}

}
