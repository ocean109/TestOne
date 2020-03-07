package com.example.demo.com.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//保险跟踪记录表insFollow(主要存放员工跟客户沟通)
public class InsFollow implements Serializable{

	private Integer id; //主键id
	private Date recordDate; //填写记录表的时间
	private String recorddate;  //前台
	private String recordText;//所填写的内容
	private Date nextDate; //下次回访时间
	private String nextdate;//前台
	private Integer insId; //外键,参考保险表id
	
	
	
	public String getRecorddate() {
		return recorddate;
	}
	public void setRecorddate(String recorddate) {
		SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date=	sif.parse(recorddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.recordDate= date;
		this.recorddate = recorddate;
	}
	public String getNextdate() {
		return nextdate;
	}
	public void setNextdate(String nextdate) {
		SimpleDateFormat sif = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date=	sif.parse(nextdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.nextDate= date;
		this.nextdate = nextdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.recorddate=sdf.format(recordDate);
		this.recordDate = recordDate;
	}
	public String getRecordText() {
		return recordText;
	}
	public void setRecordText(String recordText) {
		this.recordText = recordText;
	}
	public Date getNextDate() {
		return nextDate;
	}
	public void setNextDate(Date nextDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.nextdate=sdf.format(nextDate);
		this.nextDate = nextDate;
	}
	public Integer getInsId() {
		return insId;
	}
	public void setInsId(Integer insId) {
		this.insId = insId;
	}
	public InsFollow(Integer id, Date recordDate, String recordText,
			Date nextDate, Integer insId) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.recordText = recordText;
		this.nextDate = nextDate;
		this.insId = insId;
	}
	public InsFollow() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InsFollow [id=" + id + ", recordDate=" + recordDate
				+ ", recordText=" + recordText + ", nextDate=" + nextDate
				+ ", insId=" + insId + "]";
	}
	
	
	
}
