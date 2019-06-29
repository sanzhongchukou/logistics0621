package com.zpl.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpl.dto.CustomerDto;
import com.zpl.mapper.CustomerMapper;
import com.zpl.pojo.BasicData;
import com.zpl.pojo.Customer;
import com.zpl.pojo.CustomerExample;
import com.zpl.pojo.Role;
import com.zpl.pojo.User;
import com.zpl.service.IBasicService;
import com.zpl.service.ICustomerService;
import com.zpl.service.IUserService;
import com.zpl.utils.Constant;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private IUserService userService;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private IBasicService basicService;
	/**
	 * 当前用户如果是  业务员 只能查看所属的客户
	 * 如果是 操作员 或者 管理员 能查看所有的客户
	 */
	@Override
	public PageInfo<CustomerDto> queryPage(CustomerDto dto,User user) {
		
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		
		// 获取角色信息
		List<Role> list = userService.queryRoleByUserId(user.getUserId());
		boolean flag = false;
		if(list != null && list.size() > 0){
			for (Role role : list) {
				if(Constant.ROLE_ADMIN.equals(role.getRoleName()) 
						|| Constant.ROLE_OPERATOR.equals(role.getRoleName())){
					// 拥有操作员或者管理员的身份，查询所有的客户信息
					flag = true;
					break;
				}
			}
		}
		// 业务员 限制查询
		Customer customer = new Customer();
		if(flag == false){
			customer.setUserId(user.getUserId());
		}
		List<CustomerDto> customers = customerMapper.queryView(customer);
		return new PageInfo<>(customers);
	}
	/**
	 * 新增客户
	 *    查询 所有的角色是业务员的用户
	 *    查询 常用区间 基础数据
	 * 修改客户
	 * 	      查询 所有的角色是业务员的用户
	 *    查询 常用区间 基础数据
	 *    根据客户ID 查询详细信息
	 */
	@Override
	public void getUpdateInfo(Integer id, Model m) {
		// 1.查询所有具有业务员角色的用户信息
		List<User> users = userService.queryUserByRoleName(Constant.ROLE_SALEMAN);
		// 2.查询 常用区间的基础数据
		List<BasicData> intervals = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		if (id != null && id > 0) {
			Customer customer = new Customer();
			customer.setCustomerId(id);
			// 查询更新需要的数据
			List<CustomerDto> list = customerMapper.queryView(customer);
			if(list != null&& list.size()==1){
				m.addAttribute("dto", list.get(0));
			}
		}
		m.addAttribute("users", users);
		m.addAttribute("intervals", intervals);
	}
	
	@Override
	public void addCustomer(Customer customer) {
		customerMapper.insertSelective(customer);
		
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
		
	}
	/**
	 * 删除客户信息
	 *  如果客户已经有订单生成  那么肯定不能删除该信息
	 */
	@Override
	public boolean deleteCustomer(Integer id) {
		// 判断该客户是否有订单生成
		int count = customerMapper.hashOrder(id);
		if(count == 0){
			// 表示可以删除
			customerMapper.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}
	
	/**
	 * 查询客户信息
	 *    业务员：只能查询自己管理的客户
	 *    操作员和管理员：可以查看所有的客户
	 *    非以上角色是查看不了客户信息的
	 */
	@Override
	public List<CustomerDto> query(Customer customer) {
		
		CustomerExample example = new CustomerExample();
		// 获取当前登录的用户信息
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if(subject.hasRole(Constant.ROLE_SALEMAN)){
			// 业务员的情况 根据业务员编号查询
			example.createCriteria().andUserIdEqualTo(user.getUserId());
			return customerMapper.selectByExample(example);
		}else if(subject.hasRole(Constant.ROLE_OPERATOR) || subject.hasRole(Constant.ROLE_ADMIN)){
			// 查询所有
			return customerMapper.selectByExample(example );
		}
		// 既不是业务员也不是操作员和管理员
		return null;
	}
}
