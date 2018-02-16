package com.jp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jp.bean.Command;
import com.jp.bean.Command_Content;
import com.jp.util.DBAccess;

/**
 * ��ָ����Ӧ�����ݿ������
 * @author Administrator
 *
 */
public class CommandDao {
	/**
	 * ��ѯ��ȡָ��
	 * @param command
	 * @param description
	 * @return
	 */
	public static List<Command> queryCommand(String command, String description){
		List<Command> commandList = new ArrayList<Command>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			Command comm = new Command();
			comm.setName(command);
			comm.setDescription(description);
			//ִ��sql���
			commandList = sqlSession.selectList("Command.queryCommandList", comm);
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
		return commandList;
	}
	/**
	 * ɾ������
	 * @param id ָ���ظ����ݵ� id
	 */
	public static void deleteOne(int commandId, int contentId){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//ִ��sql���
			sqlSession.delete("Command_Content.deleteOne", contentId);
			sqlSession.commit();
			//���Ҹ�ָ���µ����ݵ������Ƿ�Ϊ��
			//�� ��ɾ�� command���е�ָ��
			List<Command_Content> contentList = new ArrayList<Command_Content>();
			contentList = sqlSession.selectList("Command_Content.selectCommandContent", commandId);
			if(contentList==null || (contentList!=null&&contentList.size()==0)){
				sqlSession.delete("Command.delete", commandId);
				sqlSession.commit();
			}
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
	/**
	 * ɾ������
	 * @param ids
	 */
	public static void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//ִ��sql���
			sqlSession.delete("Command_Content.deleteBatch", ids);
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
	/**
	 * ���ָ��
	 * @param command
	 * @param description
	 * @param content
	 */
	public static void addCommand(String command, String description, String content){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//�����Ƿ���� command ָ��
			List<Command> commandList = new ArrayList<Command>();
			commandList = sqlSession.selectList("Command.selectCommand", command);
			int commandId;
			//����������
			if(commandList==null||commandList.size()==0){
				Command comm = new Command();
				comm.setName(command);
				comm.setDescription(description);
				//���뵽command����
				sqlSession.update("Command.addCommand", comm);
				//��ȡ����󷵻ص�����ֵ���� command �� id
				commandId = comm.getId(); 
			} else{
				//����Ѿ��������ֱ�ӻ�ȡ command ��ID
				commandId = commandList.get(0).getId();
			}
			Command_Content commandContent = new Command_Content();
			commandContent.setCommand_id(commandId);
			commandContent.setContent(content);
			sqlSession.update("Command_Content.addContent", commandContent);
			//�ύ
			sqlSession.commit();
			//System.out.println(commandId);
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
	/**
	 * �޸� command ���е����� description
	 * @param commandId  ָ��ID
	 * @param newDescription �µ�ָ������
	 */
	public static void fixDescription(int commandId, String newDescription){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			Command comm = new Command();
			comm.setId(commandId);
			comm.setDescription(newDescription);
			//�޸�ָ������
			sqlSession.selectList("Command.fixDescription", comm);
			//�ύ
			sqlSession.commit();
			//System.out.println(commandId);
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
	/**
	 * �޸� command_content ���е����� content
	 * @param contentId ����ID
	 * @param newContent �µ�����
	 */
	public static void fixContent(int contentId, String newContent){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			Command_Content commandContent = new Command_Content();
			commandContent.setId(contentId);
			commandContent.setContent(newContent);
			//�޸�ָ������
			sqlSession.selectList("Command_Content.fixContent", commandContent);
			//�ύ
			sqlSession.commit();
			//System.out.println(commandId);
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
}
