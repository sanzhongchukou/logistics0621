package com.zpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zpl.dto.OrderDto;
import com.zpl.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Integer id,Model m){
		orderService.getUpdateInfo(id, m);
		return "order/orderUpdate";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveOrder(@RequestBody OrderDto dto){
		orderService.addOrder(dto);
		return "success";
	}
}
