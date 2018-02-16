package com.jp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jp.bean.Command;
import com.jp.bean.Command_Content;
import com.jp.util.DBAccess;

/**
 * 与指令表对应的数据库操作类
 * @author Administrator
 *
 */
public class CommandDao {
	/**
	 * 查询获取指令
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
			//执行sql语句
			commandList = sqlSession.selectList("Command.queryCommandList", comm);
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
		return commandList;
	}
	/**
	 * 删除单条
	 * @param id 指定回复内容的 id
	 */
	public static void deleteOne(int commandId, int contentId){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//执行sql语句
			sqlSession.delete("Command_Content.deleteOne", contentId);
			sqlSession.commit();
			//查找该指令下的内容的条数是否为空
			//是 则删除 command表中的指令
			List<Command_Content> contentList = new ArrayList<Command_Content>();
			contentList = sqlSession.selectList("Command_Content.selectCommandContent", commandId);
			if(contentList==null || (contentList!=null&&contentList.size()==0)){
				sqlSession.delete("Command.delete", commandId);
				sqlSession.commit();
			}
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
	/**
	 * 删除多条
	 * @param ids
	 */
	public static void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//执行sql语句
			sqlSession.delete("Command_Content.deleteBatch", ids);
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
	/**
	 * 添加指令
	 * @param command
	 * @param description
	 * @param content
	 */
	public static void addCommand(String command, String description, String content){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			//查找是否存在 command 指令
			List<Command> commandList = new ArrayList<Command>();
			commandList = sqlSession.selectList("Command.selectCommand", command);
			int commandId;
			//如果命令不存在
			if(commandList==null||commandList.size()==0){
				Command comm = new Command();
				comm.setName(command);
				comm.setDescription(description);
				//插入到command表中
				sqlSession.update("Command.addCommand", comm);
				//获取插入后返回的主键值，即 command 的 id
				commandId = comm.getId(); 
			} else{
				//如果已经存在命令，直接获取 command 的ID
				commandId = commandList.get(0).getId();
			}
			Command_Content commandContent = new Command_Content();
			commandContent.setCommand_id(commandId);
			commandContent.setContent(content);
			sqlSession.update("Command_Content.addContent", commandContent);
			//提交
			sqlSession.commit();
			//System.out.println(commandId);
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
	/**
	 * 修改 command 表中的描述 description
	 * @param commandId  指令ID
	 * @param newDescription 新的指令描述
	 */
	public static void fixDescription(int commandId, String newDescription){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			Command comm = new Command();
			comm.setId(commandId);
			comm.setDescription(newDescription);
			//修改指令描述
			sqlSession.selectList("Command.fixDescription", comm);
			//提交
			sqlSession.commit();
			//System.out.println(commandId);
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
	/**
	 * 修改 command_content 表中的内容 content
	 * @param contentId 内容ID
	 * @param newContent 新的内容
	 */
	public static void fixContent(int contentId, String newContent){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			Command_Content commandContent = new Command_Content();
			commandContent.setId(contentId);
			commandContent.setContent(newContent);
			//修改指令描述
			sqlSession.selectList("Command_Content.fixContent", commandContent);
			//提交
			sqlSession.commit();
			//System.out.println(commandId);
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
}
