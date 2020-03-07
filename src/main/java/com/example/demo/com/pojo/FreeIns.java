package com.example.demo.com.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//免险表freeIns(主要存放要到的客户信息)
public class FreeIns implements Serializable {
	private Integer id;
	private String customName;//客户姓名
	private String customSex;//客户性别
	private Integer customAge;//客户年龄
	private String addr;//客户地址
	private String phone;//客户电话
	private Integer status;//状态
	private Integer userId;//参考员工表id
	private Date inputDate;//录入时间
	private String inPutDate;
	private String remark;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getCustomSex() {
		return customSex;
	}
	public void setCustomSex(String customSex) {
		this.customSex = customSex;
	}
	public Integer getCustomAge() {
		return customAge;
	}
	public void setCustomAge(Integer customAge) {
		this.customAge = customAge;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getInputDate() {
		return inPutDate;
	}
	public void setInputDate(Date inputDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.inPutDate=sdf.format(inputDate);
		this.inputDate = inputDate;
	}
	public String getInPutDate() {
		return inPutDate;
	}
	public void setInPutDate(String inPutDate) {
		SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sif.parse(inPutDate);
		} catch (ParseException e) {
		System.out.println("日期转换出问题了");
			e.printStackTrace();
		}
		System.out.println(date);
		this.inputDate = date;
		this.inPutDate = inPutDate;
	}
	@Override
	public String toString() {
		return "FreeIns [id=" + id + ", customName=" + customName + ", customSex=" + customSex + ", customAge="
				+ customAge + ", addr=" + addr + ", phone=" + phone + ", status=" + status + ", userId=" + userId
				+ ", inputDate=" + inputDate + ", inPutDate=" + inPutDate + "]";
	}
	public FreeIns() {
	}
	public FreeIns(Integer id, String customName, String customSex, Integer customAge, String addr, String phone,
			Integer status, Integer userId, Date inputDate, String inPutDate2) {
		super();
		this.id = id;
		this.customName = customName;
		this.customSex = customSex;
		this.customAge = customAge;
		this.addr = addr;
		this.phone = phone;
		this.status = status;
		this.userId = userId;
		this.inputDate = inputDate;
		inPutDate = inPutDate2;
	
	}
	
	
}
