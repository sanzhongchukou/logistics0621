package com.zpl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zpl.pojo.User;
/**
 * 客户不能直接访问jsp页面，需要一个控制器间接访问
 * @author Administrator
 *
 */
@Controller
public class PageController {
	/**
	 * 跟目录就跳转到login.jsp页面
	 * @return
	 */
	@RequestMapping("/")
	public String showMain(User user,Model m){
		m.addAttribute("user", user);
		return "login";
	}
	/**
	 * restful 风格
	 *    传递的是什么数据就跳转到对应的页面
	 * @param path
	 * @return
	 */
	@RequestMapping("/{path}")
	public String page(@PathVariable String path){
		
		return path;
	}
}
