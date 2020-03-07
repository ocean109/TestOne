package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.com.pojo.FreeIns;

@Mapper
public interface FreeInsMapper {
	//分配的成功后修改此用户在免险表里面的状态为0 目的是不让 分配页面再显示此用户
	public int updataStutas(int id);
	//分页展示freeIns表中的信息   
	public List<FreeIns> selectFreeInsMapper(@Param("start")int start,@Param("size")int size,@Param("userId")int userId);
	//查询总页数
	public int select();
	//添加freeIns用户
	public int addFreeIns(FreeIns freeIns);
	//根据id 删除freeIns用户
	public int deleteFreeIns(int id);
	//根据Id 查到FreeIns用户
	public FreeIns SelectOneFreeIns(int id);
	//根据Id 修改FreeIns用户信息
	public int updateFreeIns(FreeIns freeIns);
	//根据FreeIns的部分信息来查找 FreeIns
	public List<FreeIns> selectListFreeIns(FreeIns freeIns);
	//提交
	public int upFreeIns(int id);
	//查询以及提交的免险用户
	public List<FreeIns> selectFreeIns(@Param("start")int start,@Param("size")int size);
	//打回更改用户状态为未提交
	public int updata(int id);
	//查看提交的免险用户的总数
	public int selectCount();
	//确定功能  状态从提交变为确认
	public int updateStatus(int id);
	//查询所有免险用户状态为3的数据 并分页
	public List<FreeIns> selectStatus(@Param("start")int start,@Param("size")int size);
	//查询所有免险用户状态为3的数据的总是
	public int selectStatusCount();
	////保险确认页面的打回操作 打回给保险人员
	public int updateStuta(int id);
	// 查询状态为1 的对应免险员工的客户数
	public int selectAAA(int id);
	// 查询状态为1 的对应免险员工今天新增的客户数
	public int selectBBB(int id);
	
	}

