package com.zpl.service;

import org.springframework.ui.Model;

import com.zpl.dto.OrderDto;

public interface IOrderService {

	void getUpdateInfo(Integer id, Model m);

	void addOrder(OrderDto dto);

}
