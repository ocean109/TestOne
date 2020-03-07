package com.example.demo.com.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//保险表ins(主要存放要到的客户详细信息)
public class Ins implements Serializable{
	private Integer id;
	private String customName;//客户名字
	private String customSex;//客户性别
	private Integer customAge;//客户年龄
	private String addr;//客户地址
	private String phone;//客户电话
	private String idcard;//客户身份证号
	private String bankcard;//客户银行卡号
	private Integer pid;//产品编号
	private Date inputDate;//录入时间（第一次沟通时间）
	private Integer status;//状态
	private Integer userId;//（参考员工表id）
	private Integer isMarry;//婚否
	private String ismarry;
	private String remark;//备注（冗余字段）
	private String inPutDate;
	
	public String getIsmarry() {
		return ismarry;
	}
	public void setIsmarry(String ismarry) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		if(ismarry.equals("已婚")) {
			System.out.println("---------------------------------------------");
			this.isMarry=1;
		}else {
			this.isMarry=2;
		}
		this.ismarry = ismarry;
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.inPutDate=sdf.format(inputDate);
		this.inputDate = inputDate;
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
	public Integer getIsMarry() {
		return isMarry;
	}
	public void setIsMarry(Integer isMarry) {
		this.isMarry = isMarry;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public Ins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ins(Integer id, String customName, String customSex,
			Integer customAge, String addr, String phone, String idcard,
			String bankcard, Integer pid, Date inputDate, Integer status,
			Integer userId, Integer isMarry, String remark) {
		super();
		this.id = id;
		this.customName = customName;
		this.customSex = customSex;
		this.customAge = customAge;
		this.addr = addr;
		this.phone = phone;
		this.idcard = idcard;
		this.bankcard = bankcard;
		this.pid = pid;
		this.inputDate = inputDate;
		this.status = status;
		this.userId = userId;
		this.isMarry = isMarry;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Ins [id=" + id + ", customName=" + customName + ", customSex="
				+ customSex + ", customAge=" + customAge + ", addr=" + addr
				+ ", phone=" + phone + ", idcard=" + idcard + ", bankcard="
				+ bankcard + ", pid=" + pid + ", inputDate=" + inputDate
				+ ", status=" + status + ", userId=" + userId + ", isMarry="
				+ isMarry + ", remark=" + remark + "]";
	}
	
}
