package com.example.demo.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.com.pojo.RoleMenu;

@Mapper
public interface RoleMenuMapper {
	//存储对应的树结构
	public boolean insert(@Param("string")String string,@Param("idd")int idd);
	//查看有没有对应id的树结构
	public int select(@Param("idd")int idd);
	//删除对应id的树结构
	public int delete(@Param("idd")int idd);
	//查出对应idd的树结构
	public List<RoleMenu> selectIdd(@Param("idd")int idd);

}
