package com.example.demo.com.pojo;
//角色_菜单表roleMenu(主要存放角色对应的菜单)
public class RoleMenu {

	private Integer rid;//角色id（参考角色表id）
	private	String menuNum;//菜单编号
	private	String remark;//备注
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public RoleMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleMenu(Integer rid, String menuNum, String remark) {
		super();
		this.rid = rid;
		this.menuNum = menuNum;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Rolemenu [rid=" + rid + ", menuNum=" + menuNum + ", remark="
				+ remark + "]";
	}
	
	
}
