package com.jp.dao;

/**
 * �û������߼���
 * @author Administrator
 *
 */
public class UserDao {
	/**
	 * ����Ա��½
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
