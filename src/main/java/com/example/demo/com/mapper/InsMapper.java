package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.com.pojo.FreeIns;
import com.example.demo.com.pojo.Ins;

@Mapper
public interface InsMapper {
	
	//查询免险那员工的信息 id1   
	public FreeIns selectFreeIns(int id1);
	//将查出来的免险信息存入保险用户的信息  
	public int addInt(FreeIns freeIns);
	//改变保险用户的userId和status
	public int updata(@Param("id2")int id2,@Param("id1")int id1);
	//查询所有的保险用户
	public List<Ins> selectInsAll(int userId);
	//修改ins用户的信息
	public int updataIns(Ins ins);
	////购买保险
	public int updateProduct(@Param("id1")int id1,@Param("id2")int id2);
	//购买后提交给经理  改变状态
	public int updataStatus(int id);
	//经理确认后给财务   改变状态
	public int status(int id);
	//	//经理打回给保险人员   改变状态
	public int updataInsStatus(int id);
	//财务确认付款
	public int updataStatuszf(int id);
	//财务查看经理确认后的所有人的保险人信息
	public List<Ins> selectInsAllzf();
	//财务打回到经理
	public int updataInsstatuss(int id);
	////经理确认保险
	public List<Ins> selectINS();
	
}
