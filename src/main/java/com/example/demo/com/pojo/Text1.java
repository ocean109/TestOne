package com.example.demo.com.pojo;

public class Text1 {
	private int sum ;  //总数
	private int daysum; //今天新增加的数
	public Text1() {}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getDaysum() {
		return daysum;
	}
	public void setDaysum(int daysum) {
		this.daysum = daysum;
	}
	@Override
	public String toString() {
		return "Text1 [sum=" + sum + ", daysum=" + daysum + "]";
	}
	

}
