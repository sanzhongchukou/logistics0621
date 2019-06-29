package com.zpl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpl.mapper.RoleMapper;
import com.zpl.pojo.Role;
import com.zpl.pojo.RoleExample;
import com.zpl.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> query() {
		RoleExample example= new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public Integer addRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(role);
	}

	@Override
	public Integer updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public Integer deleteRole(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role queryById(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}

}
