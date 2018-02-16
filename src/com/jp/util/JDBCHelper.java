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
 * JDBC��ʽ
 * �������ݿ���
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
			Class.forName(driverName);// ��������
			System.out.println("���������ɹ�!");
			conn = (Connection) DriverManager.getConnection(url, userName,
					password);
			System.out.println("�������ݿ�ɹ�!");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("���ݿ������쳣!");
			e.printStackTrace();
		}
		return conn;
	}

	public static void free(ResultSet rs, Connection conn, Statement pstm) {
		try {
			if (rs != null) {
				rs.close(); // �رս����
			}
		} catch (SQLException e) {
			System.out.println("�ر�ResultSetʧ��!");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close(); // �ر�����
				}
			} catch (SQLException e) {
				System.out.println("�ر�Connectionʧ��!");
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close(); // �ر�Statement
					}
				} catch (SQLException e) {
					System.out.println("�ر�Statementʧ��!");
					e.printStackTrace();
				}
			}
		}
		System.out.println("�ر����ݿ�����!");
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
			//ģ����ѯ
			//��ʽ��select * from message where 1 = 1 and DESCRIPTION like '%����%';
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
