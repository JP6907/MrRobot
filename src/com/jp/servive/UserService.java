package com.jp.servive;

import com.jp.dao.UserDao;

/**
 * �û����Ʒ���
 * @author Administrator
 *
 */
public class UserService {
	/**
	 * ����Ա��½
	 * @param userName
	 * @param passWord
	 */
	public boolean managerLogin(String userName, String passWord){
		return UserDao.managerLogin(userName, passWord);
	}
}
