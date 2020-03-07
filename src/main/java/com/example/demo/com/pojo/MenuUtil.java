package com.example.demo.com.pojo;

import java.io.Serializable;
//菜单工具表menuUtil(主要存放菜单所有页面)
public class MenuUtil implements Serializable{
	
	private Integer id;
	private String menuNum;  //菜单编号
	private String menuText;  //菜单内容
	private String menuUrl;  //菜单路径
	private String pmenuNum;  //上级菜单编号
	private String pmenuText;  //上级菜单内容
	private String remark;  //备注
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}
	public String getMenuText() {
		return menuText;
	}
	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getPmenuNum() {
		return pmenuNum;
	}
	public void setPmenuNum(String pmenuNum) {
		this.pmenuNum = pmenuNum;
	}
	public String getPmenuText() {
		return pmenuText;
	}
	public void setPmenuText(String pmenuText) {
		this.pmenuText = pmenuText;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "MenuUtil [id=" + id + ", menuNum=" + menuNum + ", menuText=" + menuText + ", menuUrl=" + menuUrl
				+ ", pmenuNum=" + pmenuNum + ", pmenuText=" + pmenuText + ", remark=" + remark + "]";
	}
	public MenuUtil() {}
	public MenuUtil(Integer id, String menuNum, String menuText, String menuUrl, String pmenuNum, String pmenuText,
			String remark) {
		super();
		this.id = id;
		this.menuNum = menuNum;
		this.menuText = menuText;
		this.menuUrl = menuUrl;
		this.pmenuNum = pmenuNum;
		this.pmenuText = pmenuText;
		this.remark = remark;
	}
	
 
}
