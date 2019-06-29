package com.zpl.dto;

import java.util.List;

import com.zpl.pojo.Order;
import com.zpl.pojo.OrderDetail;

public class OrderDto extends Order{
	private List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
