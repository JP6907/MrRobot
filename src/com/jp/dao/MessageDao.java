package com.jp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jp.bean.Message;
import com.jp.util.DBAccess;
import com.jp.util.JDBCHelper;

/**
 * Message������ص��߼����Ʋ�
 * @author Administrator
 *
 */
public class MessageDao {
	/**
	 * �����ݿ��в�ѯָ����Message
	 * ͨ�� JDBC �ķ���
	 * @param command	����
	 * @param description	������֧��ģ����ѯ
	 * @return	Message���͵�List
	 */
	public static List<Message> queryMessagesByJDBC(String command, String description){
		List<Message> messageList = JDBCHelper.getMessages(command, description);
		return messageList;
	}
	
	/**
	 * �����ݿ��в�ѯָ����Message
	 * ͨ�� Mybatis �ķ���
	 * @param command	����
	 * @param description	������֧��ģ����ѯ
	 * @return	Message���͵�List
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
			//ִ��sql���
			messageList = sqlSession.selectList("Message.queryMessageList", msg);
		}catch(Exception e){
			e.printStackTrace();
			//�رջỰ����
			sqlSession.close();
		}finally{
			//�رջỰ����
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return messageList;
	}
	/**
	 * ɾ������
	 * @param id ָ�� id
	 */
	public static void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//ִ��sql���
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//�رջỰ����
			sqlSession.close();
		}finally{
			//�رջỰ����
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
			//ִ��sql���
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			//�رջỰ����
			sqlSession.close();
		}finally{
			//�رջỰ����
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
//		 //�ȼ��ɵ͵���
//		log.debug("adf");
//		log.info(message);
//		log.warn(message);
//		log.error(message);
//	}
}
