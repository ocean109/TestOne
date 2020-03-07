package com.example.demo.com.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class PageBean implements Serializable{
	private Integer total;//总数
	/**
	 *  start=(page-1 * rows)
	 *  从前台获取当前页以及每页要显示的页数，拿到的是string类型 要转换为integer类型
	 */
	private List rows;//每页显示的数据
	
	public PageBean() {}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageBean [total=" + total + ", rows=" + rows + "]";
	}

	public PageBean(Integer total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	
	
}
