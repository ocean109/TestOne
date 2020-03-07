package com.example.demo.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.FreeInsMapper;
import com.example.demo.com.mapper.InsMapper;
import com.example.demo.com.pojo.FreeIns;
import com.example.demo.com.pojo.Ins;

@Service
public class InsServiceImp implements InsService {

	@Resource
	private InsMapper insMapper;
	@Resource 
	private FreeInsMapper freeInsMapper;

	//查询免险那员工的信息 id1   
	public FreeIns selectFreeIns(int id1) {
		FreeIns freeIns = insMapper.selectFreeIns(id1);
		return freeIns;
	}

	//将查出来的免险信息存入保险用户的信息  
	public int addInt(FreeIns freeIns) {
		int i = insMapper.addInt(freeIns);
		return i;
	}

	//改变保险用户的userId和status
	public int updata(int id2, int id1) {
		int i = insMapper.updata(id2, id1);
		return i;
	}
	//改变状态并且 分配  1.改 查（改）   存 改
	public boolean addIntOne(int id1,int id2) {
		FreeIns freeIns=this.selectFreeIns(id1);
		boolean b = false;
		if(freeIns!=null) {
			int i =this.addInt(freeIns);
			System.out.println("InsServiceImp i="+i);
			if(i>0) {
			 int w = this.updata(id2, id1);
			 int ii = freeInsMapper.updataStutas(id1);
			 if(ii>0) {
				 b =true;
				 //然后去免险表里面把用户对应的status状态改为0表示以及被成功分配不让分配页面显示 
			 }
			 
			}else {
				System.out.println("保存失败"+i);
			}
		}else {
			System.out.println("freeIns为空"+freeIns);
		}
		return b;
	}

	//查询所有的保险用户
	public List<Ins> selectInsAll(int userId) {
		List<Ins> insList = insMapper.selectInsAll(userId);
		return insList;
	}

	//修改ins用户的信息
	public boolean updataIns(Ins ins) {
		int i = insMapper.updataIns(ins);
		return i>0?true:false;
	}

	//购买保险
	public boolean updateProduct(int id1, int id2) {
		int i = insMapper.updateProduct(id1, id2);
	System.out.println("i = "+i);
		return i>0?true:false;
	}

	//购买后提交给经理  改变状态
	public boolean updataStatus(int id) {
	int i = insMapper.updataStatus(id);
		return i>0?true:false;
	}

	//经理确认后给财务   改变状态
	public boolean status(int id) {
		int i = insMapper.status(id);
		return i>0?true:false;
	}

	//经理打回给保险人员   改变状态
	public boolean updataInsStatus(int id) {
		int i = insMapper.updataInsStatus(id);
		return i>0?true:false;
	}

	//财务确认付款
	public boolean updataStatuszf(int id) {
	   int i = insMapper.updataStatuszf(id);
		return i>0?true:false;
	}

	//财务查看经理确认后的所有人的保险人信息
	public List<Ins> selectInsAllzf() {
		List<Ins> list = insMapper.selectInsAllzf();
		System.out.println("****** list"+list);
		return list;
	}

	//财务打回到经理
	public boolean updataInsstatus(int id) {
		int i  = insMapper.updataInsstatuss(id);
		return i>0?true:false;
	}

	///经理确认保险
		
	public List<Ins> selectINS() {
		List<Ins> list = insMapper.selectINS();
		return list;
	}
	

}
