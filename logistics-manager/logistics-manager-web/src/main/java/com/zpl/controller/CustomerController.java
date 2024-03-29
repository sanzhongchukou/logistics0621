package com.zpl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.zpl.dto.CustomerDto;
import com.zpl.pojo.Customer;
import com.zpl.pojo.User;
import com.zpl.service.ICustomerService;
import com.zpl.utils.Constant;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/query")
	public String query(CustomerDto dto,Model m){
		// 获取登录用户信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		System.out.println("--->"+user.getUserId());
		PageInfo<CustomerDto> list = customerService.queryPage(dto,user);
		m.addAttribute(Constant.PAGE_MODEL, list);
		return "customer/customer";
	}
	
	@RequestMapping("/customerUpdate")
	public String customerUpdate(Integer id,Model model){
		customerService.getUpdateInfo(id, model);
		return "customer/customerUpdate";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(Customer customer) {
		if(customer.getCustomerId()!=null && !"".equals(customer.getCustomerId())){
			// 更新
			customerService.updateCustomer(customer);
		}else{
			// 添加
			customerService.addCustomer(customer);
		}
		return "redirect:/customer/query";
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		boolean flag = customerService.deleteCustomer(id);
		String msg = "数据删除成功!!!";
		if(!flag){
			// 表示删除失败，不能被删除
			msg = "该用户不能被删除，请联系管理员！";
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<script type='text/javascript'>");
		out.append("alert('"+msg+"');");
		out.append("location.href='/customer/query';");
		out.append("</script>");
		out.flush();
		out.close();
	}
}
