package com.zpl.dto;

import java.util.List;

import com.zpl.pojo.User;

public class UserDto extends BasePage{
	//用户信息
	private User user;
	//关联分配的角色信息id
	private List<Integer> roleIds;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	

	
	
}
