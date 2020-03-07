package com.example.demo.com.pojo;

import java.io.Serializable;
/*
 * 转换easyui树结构前台属性和后台属性保持一致
 */
public class TreeBean implements Serializable{
	private String pid;//父级别菜单编号
	private String id;//菜单编号
	private String text;//菜单名称
	private String attributes;//菜单对应的路径url
	private boolean checked=false;//菜单是否被选中
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
	public TreeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TreeBean [pid=" + pid + ", id=" + id + ", text=" + text
				+ ", attributes=" + attributes + "]";
	}
	
	public TreeBean(String pid, String id, String text, String attributes) {
		super();
		this.pid = pid;
		this.id = id;
		this.text = text;
		this.attributes = attributes;
	}
	
	public TreeBean(String pid, String id, String text, String attributes,
			boolean checked) {
		super();
		this.pid = pid;
		this.id = id;
		this.text = text;
		this.attributes = attributes;
		this.checked = checked;
	}
	
	
	
}
