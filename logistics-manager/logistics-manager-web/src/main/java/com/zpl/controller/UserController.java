package com.zpl.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.zpl.dto.UserDto;
import com.zpl.pojo.User;
import com.zpl.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	/**
	 * 查询用户信息并跳转到展示页面
	 * @param m
	 * @return
	 */
	@RequestMapping("/query")
	//@ResponseBody
	public String userQuery(User user,Model m)throws Exception{
		
		List<User> list=userService.query(null);
	/*	for (User user : list) {
			System.out.println(user);
		}*/
		m.addAttribute("list", list);
		return "user/user";
	}
	/**
	 * 分页查询
	 * @param m
	 * @return
	 * @throws Exception
	 */
	// 当前登录用户需要"管理员角色才能访问"
	@RequiresRoles("管理员")
	@RequestMapping("/queryPage")
	public String userQueryPage(UserDto dto,Model m)throws Exception{
		PageInfo<User> pageModel = userService.queryPage(dto);
		
		m.addAttribute("pageModel", pageModel);
		return "user/user";
	}
	/**
	 * 进入添加或者修改页面
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/userUpdate")
	public String userUpdatePage(Integer id,Model m)throws Exception{
		
		userService.getUpdateUserInfo(id,m);
		return "user/userUpdate";
	}
	/**
	 * 添加或者修改页面进行更新或保存数据
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/saveOrUpdate")
	public String saveUpdatePage(UserDto userDto) throws Exception{
		
		//System.out.println(userDto);
		userService.saveOrUpdate(userDto);
		return "redirect:/user/queryPage";
	}
	@RequestMapping("/delete")
	public String deleteUser(Integer id) throws Exception{
		userService.deleteUser(id);
		
		return "redirect:/user/queryPage";
	}
}
