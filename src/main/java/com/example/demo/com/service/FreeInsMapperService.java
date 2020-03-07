package com.example.demo.com.service;

import java.util.List;

import com.example.demo.com.mapper.FreeInsMapper;
import com.example.demo.com.pojo.FreeIns;

public interface FreeInsMapperService {
	
	//分页查询的FreeInsMapper
	public List<FreeIns> selectFreeInsMapper(int start,int size,int userId);
	//查询总页数
	public int select();
	//添加FreeIns用户
	public  boolean addFreeIns(FreeIns freeIns);
	//根据id删除FreeIns用户
	public boolean deleteFreeIns(int id);
	//根据id 查找freeIns用户
	public FreeIns selectOneFreeIns(int id);
	//根据id 修改freeIns用户的信息
	public boolean updateFreeIns(FreeIns freeIns);
	//根据 freeIns的部分信息  查询freeIns
	public List<FreeIns> selectListFreeIns(FreeIns freeIns);
	//提交
	public boolean upFreeIns(int id);
	 //查询以及提交的免险用户
	public List<FreeIns> selectFreeIns(int start,int size);
	//打回更改用户状态为未提交
	public boolean updata(int id);
	//查看提交的免险用户的总数
	public int selectCount();
	//确定功能  状态从提交变为确认
	public boolean updateStatus(int id);
	//查询所有免险用户状态为3的数据 并分页
	public List<FreeIns> selectStatus(int start,int size);
	//查询所有免险用户状态为3的数据的总是
	public int selectStatusCount();
////保险确认页面的打回操作 打回给保险人员
	public boolean updateStuta(int id);
	// 查询状态为1 的对应免险员工的客户数
		public int selectAAA(int id);
		// 查询状态为1 的对应免险员工今天新增的客户数
		public int selectBBB(int id);
	
}
