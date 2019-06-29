package com.zpl.dto;

import com.zpl.pojo.Customer;

public class CustomerDto extends BasePage{
	
	private Customer customer;
	//业务员
	private String realName;
	//常用区间
	private String commonInterval;
	//订单个数
	private Integer orderNum;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCommonInterval() {
		return commonInterval;
	}
	public void setCommonInterval(String commonInterval) {
		this.commonInterval = commonInterval;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
}
