package com.example.demo.com.pojo;

import java.io.Serializable;
//产品表product(主要存放保险产品)
public class Product implements Serializable{
		private Integer id;		
		private String pname;	//保险产品名称
		private String cycle;	//周期
		private String price;	//产品价格
		private String remark;	//备注
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getCycle() {
			return cycle;
		}
		public void setCycle(String cycle) {
			this.cycle = cycle;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Product(Integer id, String pname, String cycle, String price,
				String remark) {
			super();
			this.id = id;
			this.pname = pname;
			this.cycle = cycle;
			this.price = price;
			this.remark = remark;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", pname=" + pname + ", cycle="
					+ cycle + ", price=" + price + ", remark=" + remark + "]";
		}
		
}
