package com.jp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jp.bean.Message;
import com.jp.util.DBAccess;
import com.jp.util.JDBCHelper;

/**
 * Message对象相关的逻辑控制层
 * @author Administrator
 *
 */
public class MessageDao {
	/**
	 * 从数据库中查询指定的Message
	 * 通过 JDBC 的方法
	 * @param command	命令
	 * @param description	描述，支持模糊查询
	 * @return	Message类型的List
	 */
	public static List<Message> queryMessagesByJDBC(String command, String description){
		List<Message> messageList = JDBCHelper.getMessages(command, description);
		return messageList;
	}
	
	/**
	 * 从数据库中查询指定的Message
	 * 通过 Mybatis 的方法
	 * @param command	命令
	 * @param description	描述，支持模糊查询
	 * @return	Message类型的List
	 */
	public static List<Message> queryMessagesByMybatis(String command, String description){
		List<Message> messageList = new ArrayList<Message>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			Message msg = new Message();
			msg.setCommand(command);
			msg.setDscription(description);
			//执行sql语句
			messageList = sqlSession.selectList("Message.queryMessageList", msg);
		}catch(Exception e){
			e.printStackTrace();
			//关闭会话对象
			sqlSession.close();
		}finally{
			//关闭会话对象
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	/**
	 * 删除单条
	 * @param id 指定 id
	 */
	public static void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//执行sql语句
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//关闭会话对象
			sqlSession.close();
		}finally{
			//关闭会话对象
			if(sqlSession!=null){
				sqlSession.close();
			}
		} 
	}
	
	public static void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//执行sql语句
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//关闭会话对象
			sqlSession.close();
		}finally{
			//关闭会话对象
			if(sqlSession!=null){
				sqlSession.close();
			}
		} 
	}
//	public static void main(String[] args){
//		List<Message> messageList = queryMessagesByMybatis(null, null);
//		System.out.println(messageList.size());
//		
//		Logger log;
//		 //等级由低到高
//		log.debug("adf");
//		log.info(message);
//		log.warn(message);
//		log.error(message);
//	}
}
