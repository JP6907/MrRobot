package com.jp.servive;

import com.jp.dao.UserDao;

/**
 * 用户控制服务
 * @author Administrator
 *
 */
public class UserService {
	/**
	 * 管理员登陆
	 * @param userName
	 * @param passWord
	 */
	public boolean managerLogin(String userName, String passWord){
		return UserDao.managerLogin(userName, passWord);
	}
}
