package com.zpl.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.zpl.dto.UserDto;
import com.zpl.pojo.Role;
import com.zpl.pojo.User;

public interface IUserService {
	
	public List<User> query(User user);
	
	public Integer addUser(User user)throws Exception;
	
	public Integer updateUser(User user)throws Exception;
	
	public Integer deleteUser(Integer id)throws Exception;
	
	public User queryById(Integer id);
	/**
	 * 获取添加或者修改用户需要的数据
	 * 添加
	 *    获取所有的角色信息
	 * 修改
	 *    获取所有的角色信息及根据id查询的用户信息
	 * @param id
	 * @return
	 */
	public void getUpdateUserInfo(Integer id, Model m)throws Exception;
	/**
	 * 保存或修改用户数据
	 * @param userDto
	 */
	public void saveOrUpdate(UserDto userDto)throws Exception;
	
	/**
	 * 分页带条件查询用户信息
	 * @param dto
	 * @return
	 */
	public PageInfo<User> queryPage(UserDto dto);
	
	/**
	 * 根据用户编号获取对应的权限信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> queryRoleByUserId(Integer id);
	/**
	* 根据角色名称查询对应的用户信息
	 * @param roleName
	 * @return
	 */
	public List<User> queryUserByRoleName(String roleName);
}
