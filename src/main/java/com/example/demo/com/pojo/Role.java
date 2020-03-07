package com.example.demo.com.pojo;

import java.io.Serializable;
//角色表role(主要存放员工角色)
public class Role implements Serializable{

	private Integer id;
	private String rname;// 角色名称
	private Integer level;//等级
	private String remark;//备注
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Integer id, String rname, Integer level, String remark) {
		super();
		this.id = id;
		this.rname = rname;
		this.level = level;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rname=" + rname + ", level=" + level
				+ ", remark=" + remark + "]";
	}
	
}
