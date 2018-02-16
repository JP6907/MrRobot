package com.jp.servive;

import java.util.List;
import java.util.Random;

import com.jp.bean.Command;
import com.jp.bean.Command_Content;
import com.jp.bean.Message;
import com.jp.dao.CommandDao;
import com.jp.dao.MessageDao;
import com.jp.util.Iconst;
import com.jp.util.TuLingUtil;

/**
 * list 页面相关的业务功能
 * @author Administrator
 *
 */
public class QueryService {
	/**
	 * 从数据库中查询指定的Command
	 * @param command	命令
	 * @param description	描述，支持模糊查询
	 * @return	Command类型的List
	 */
	public static List<Command> queryCommandList(String command, String description){
		return CommandDao.queryCommand(command, description);
	}
	/**
	 * 通过指令查询自动回复内容
	 * @param command 指令
	 * @return	自动回复内容
	 */
	public String queryByCommand(String command){
		List<Command> commandList = null;
		StringBuilder result = new StringBuilder();
		if(command.equals(Iconst.HELP_COMMAND)){
			commandList = CommandDao.queryCommand(null, null);
			for(Command com:commandList){
				result.append("回复[" + com.getName() + "] 可以查看   " + com.getDescription() + "<br>");
			}
			result.append("回复 其它内容可获得自动回复");
			return result.toString();
		}
		commandList = CommandDao.queryCommand(command, null);
		if(commandList.size()>0){
			List<Command_Content> contentList = commandList.get(0).getContentList();
			int index = new Random().nextInt(contentList.size());
			return contentList.get(index).getContent();
		}else{
			//获取图灵自动回复
			return TuLingUtil.getTuLingAnswer(command);
		}
	}
}
