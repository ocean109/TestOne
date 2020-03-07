
package com.example.demo.com.service;


import java.util.List;

import com.example.demo.com.pojo.FreeIns;
import com.example.demo.com.pojo.Ins;

public interface InsService {
	
		//查询免险那员工的信息 id1   
		public FreeIns selectFreeIns(int id1);
		//将查出来的免险信息存入保险用户的信息  
		public int addInt(FreeIns freeIns);
		//改变保险用户的userId和status
		public int updata(int id2,int id1);
		//改变状态并且 分配  1.查   存 改
		public boolean addIntOne(int id1,int id2);
		//查询所有的保险用户
		public List<Ins> selectInsAll(int userId);
		//修改ins用户的信息
		public boolean updataIns(Ins ins);
		//购买保险
		public boolean updateProduct(int id1,int id2);
		//购买后提交给经理  改变状态
		public boolean updataStatus(int id);
		//经理确认后给财务   改变状态
		public boolean status(int id);
		//经理打回给保险人员   改变状态
		public boolean updataInsStatus(int id);
		//财务查看经理确认后的所有人的保险人信息
		public List<Ins> selectInsAllzf();
		//财务打回到经理
		public boolean updataInsstatus(int id);
		///经理确认保险
		public List<Ins> selectINS();

}
