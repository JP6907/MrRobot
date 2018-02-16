package com.jp.dao;

/**
 * 用户控制逻辑层
 * @author Administrator
 *
 */
public class UserDao {
	/**
	 * 管理员登陆
	 * @param userName
	 * @param passWord
	 */
	public static boolean managerLogin(String userName, String passWord){
		if(userName!=null && passWord!=null &&			 
				userName.equals("admin") && passWord.equals("ZJPadmin")){
			return true;
		}else{
			return false;
		}
	}
}
