package com.jp.util;

import com.jp.bean.Message;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * JDBC方式
 * 访问数据库类
 * @author Administrator
 *
 */
public class JDBCHelper {
	private static String databaseName = "mrrobot";
	private static String tableName = "message";
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/" + databaseName;
	public static String userName = "root";
	public static String password = "123456";

	public static int UserExit = 1;
	public static int UserNotExit = 2;
	public static int RegisterSuccess = 3;
	public static int WrongPassWord = 4;
	public static int LoginSuccess = 5;

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverName);// 创建驱动
			System.out.println("创建驱动成功!");
			conn = (Connection) DriverManager.getConnection(url, userName,
					password);
			System.out.println("连接数据库成功!");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("数据库连接异常!");
			e.printStackTrace();
		}
		return conn;
	}

	public static void free(ResultSet rs, Connection conn, Statement pstm) {
		try {
			if (rs != null) {
				rs.close(); // 关闭结果集
			}
		} catch (SQLException e) {
			System.out.println("关闭ResultSet失败!");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close(); // 关闭连接
				}
			} catch (SQLException e) {
				System.out.println("关闭Connection失败!");
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close(); // 关闭Statement
					}
				} catch (SQLException e) {
					System.out.println("关闭Statement失败!");
					e.printStackTrace();
				}
			}
		}
		System.out.println("关闭数据库连接!");
	}


	public static List<Message> getMessages(String command, String description) {
		Connection conn = null;
		Statement stat = null;
		List<Message> messageList = new ArrayList<Message>();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder("select * from " + tableName + " where 1 = 1 ");
		if(command!=null && !command.trim().equals("")){
			sql.append("and COMMAND = '" + command + "' ");
		}
		if(description!=null && !description.trim().equals("")){
			//模糊查询
			//格式：select * from message where 1 = 1 and DESCRIPTION like '%精彩%';
			sql.append("and DESCRIPTION like '%" + description + "%'");
		}
		sql.append(";");
		try {
			conn = getConnection();
			stat = conn.createStatement();
			//System.out.println(sql.toString());
			rs = stat.executeQuery(sql.toString());
			while (rs.next()) {
				Message msg = new Message();
				msg.setId(rs.getInt("ID"));
				msg.setCommand(rs.getString("COMMAND"));
				msg.setDscription(rs.getString("DESCRIPTION"));
				msg.setContent(rs.getString("CONTENT"));
				messageList.add(msg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			free(rs, conn, stat);
		}
		return messageList;
	}
}
