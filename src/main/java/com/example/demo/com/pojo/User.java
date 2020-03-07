package com.example.demo.com.pojo;

import java.io.Serializable;
//员工表user(主要存放员工基本信息)
public class User implements Serializable{
	private Integer id;			
	private String userName;	//员工账号
	private String pwd;			//密码
	private Integer rid;		//角色编号
	private Integer level;		//员工等级
	private Integer isdel;		//是否删除	
	private String remark;		//备注（员工姓名）
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String userName, String pwd, Integer rid,
			Integer level, Integer isdel, String remark) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.rid = rid;
		this.level = level;
		this.isdel = isdel;
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd
				+ ", rid=" + rid + ", level=" + level + ", isdel=" + isdel
				+ ", remark=" + remark + "]";
	}
}
