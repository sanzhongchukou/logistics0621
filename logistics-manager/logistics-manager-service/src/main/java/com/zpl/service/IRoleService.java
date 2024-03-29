package com.zpl.service;

import java.util.List;

import com.zpl.pojo.Role;

public interface IRoleService {
	
	public List<Role> query();
	
	public Integer addRole(Role role);
	
	public Integer updateRole(Role role);
	
	public Integer deleteRole(Integer id);
	
	public Role queryById(Integer id);
}
