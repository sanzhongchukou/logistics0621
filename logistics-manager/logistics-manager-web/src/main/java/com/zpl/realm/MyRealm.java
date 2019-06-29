package com.zpl.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.zpl.pojo.Role;
import com.zpl.pojo.User;
import com.zpl.service.IUserService;
/**
 * 自定义的Realm
 * @author 波波烤鸭
 *
 * dengpbs@163.com
 */
public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private IUserService userService;
	/**
	 * 认证的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取提交的账号
		UsernamePasswordToken t =(UsernamePasswordToken)token;
		// 获取登录的账号
		String userName = t.getUsername();
		User user = new User();
		user.setUserName(userName);
		
		List<User> list = null;
		try {
			 list = userService.query(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		if (list == null || list.size() != 1) {
			// 账号不存在或者用户过多都返回null
			System.out.println("账号不存在或者用户过多");
			return null;
		}
		//封装的有登录的用户的信息
		user = list.get(0);

		SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(user, user.getPassword(), new SimpleByteSource(user.getU1()),"myRealm");
		return info;
	}
	/**
	 * 授权的方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取认证的信息
		User user = (User) principals.getPrimaryPrincipal();
		// 获取登录用户对应的权限
	
		List<Role> roles = userService.queryRoleByUserId(user.getUserId());
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(roles!= null && roles.size() > 0){
			for (Role role : roles) {
				
				info.addRole(role.getRoleName());
			}
		}
		
		return info;
	}
	
//	public static void main(String[] args) {
//		System.out.println(new Md5Hash("123456", "c7d83c3a-afa3-4222-b07d-aaec84f94e5d", 1024));
//	}
}
