package com.example.demo.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.com.mapper.FreeInsMapper;
import com.example.demo.com.pojo.FreeIns;

@Service

public class FreeInsMapperServiceImpl implements FreeInsMapperService {
	
	@Resource
	private FreeInsMapper freeInsMapper;
	//显示所有的信息
	public List<FreeIns> selectFreeInsMapper(int start,int size,int userId) {
		List<FreeIns> freeInsMapperList = freeInsMapper.selectFreeInsMapper(start,size,userId);
		return freeInsMapperList;
	}
	//查询总页数
	public int select() {
		int i = freeInsMapper.select();
		return i;
	}
	//添加一个freeIns 成功或者否
	public boolean addFreeIns(FreeIns freeIns) {
		boolean b = false;
		int i=freeInsMapper.addFreeIns(freeIns);
		if(i >0 ) {
			b = true;
		}
		return b;
	}
	//根据id删除freeIns用户   是否成功
	public boolean deleteFreeIns(int id) {
		boolean b = false;
		int i=freeInsMapper.deleteFreeIns(id);
		if(i >0 ) {
			b = true;
		}
		return b;
	}
	//根据
	public FreeIns selectOneFreeIns(int id) {
		FreeIns freeIns = freeInsMapper.SelectOneFreeIns(id);
		
		return freeIns;
	}
	//根据id 修改freeIns用户的信息
	public boolean updateFreeIns(FreeIns freeIns) {
		boolean b = false;
		int i = freeInsMapper.updateFreeIns(freeIns);
		if(i>0) {
			b=true;
		}
		return b;
	}
	//根据 freeIns的部分信息  查询freeIns
	public List<FreeIns> selectListFreeIns(FreeIns freeIns) {
		List<FreeIns> freeInsList= freeInsMapper.selectListFreeIns(freeIns);
		return freeInsList;
	}
	//提交
	public boolean upFreeIns(int id) {
		int i =freeInsMapper.upFreeIns(id);
		boolean b = false;
		if(i>0) {
			b=true;
		}
		return b;
	}
	 //查询以及提交的免险用户
	public List<FreeIns> selectFreeIns(int start,int size) {
     List<FreeIns> list=	freeInsMapper.selectFreeIns(start,size);
     System.out.println("///////////////list"+list);
	 return list;
	}
	//打回更改用户状态为未提交
	public boolean updata(int id) {
		int i = freeInsMapper.updata(id);
		System.out.println("[][]][][[]"+i);
		return i>0?true:false;
	}
	//返回免险已经提交用户的总数
	public int selectCount() {
		
		return freeInsMapper.selectCount();
	}
	//确定功能  状态从提交变为确认
	public boolean updateStatus(int id) {
		int i = freeInsMapper.updateStatus(id);
		return i>0?true:false;
	}
	//查询所有免险用户状态为3的数据 并分页
	public List<FreeIns> selectStatus(int start,int size) {
		List<FreeIns> list = freeInsMapper.selectStatus(start,size);
		return list;
	}
	//查询所有免险用户状态为3的数据的总是
	public int selectStatusCount() {
		return freeInsMapper.selectStatusCount();
	}
	//保险确认页面的打回操作 打回给保险人员
	public boolean updateStuta(int id) {
		int i = freeInsMapper.updateStuta(id);
		return i>0?true:false;
	}
	@Override
	public int selectAAA(int id) {
		int i = freeInsMapper.selectAAA(id);
		return i;
	}
	@Override
	public int selectBBB(int id) {
		int i = freeInsMapper.selectBBB(id);
		return i;
	}

}
