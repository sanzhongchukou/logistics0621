package com.zpl.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.zpl.dto.CustomerDto;
import com.zpl.pojo.Customer;
import com.zpl.pojo.User;

public interface ICustomerService {
	/**
	* 分页查询
	 * @param dto
	 * @return
	 */
	public PageInfo<CustomerDto> queryPage(CustomerDto dto,User user);
	/**
	 * 查询更新或者添加需要的信息
	 */
	public void getUpdateInfo(Integer id,Model m);
	/**
	 * 保存客户信息
	 */
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	/**
	 *删除客户信息
	 * @return 
	 */
	public boolean deleteCustomer(Integer id);
	
	public List<CustomerDto> query(Customer customer);
}
