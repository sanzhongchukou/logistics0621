package com.zpl.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zpl.pojo.Role;
import com.zpl.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/query")
	@RequiresRoles("管理员")
	public String query(Model m){
//		System.out.println("---------");
		List<Role> list=roleService.query();
//		for (Role role : list) {
//			System.out.println(role);
//		}
		m.addAttribute("list", list);
		return "role/role";
	}
}
