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
 * list ҳ����ص�ҵ����
 * @author Administrator
 *
 */
public class QueryService {
	/**
	 * �����ݿ��в�ѯָ����Command
	 * @param command	����
	 * @param description	������֧��ģ����ѯ
	 * @return	Command���͵�List
	 */
	public static List<Command> queryCommandList(String command, String description){
		return CommandDao.queryCommand(command, description);
	}
	/**
	 * ͨ��ָ���ѯ�Զ��ظ�����
	 * @param command ָ��
	 * @return	�Զ��ظ�����
	 */
	public String queryByCommand(String command){
		List<Command> commandList = null;
		StringBuilder result = new StringBuilder();
		if(command.equals(Iconst.HELP_COMMAND)){
			commandList = CommandDao.queryCommand(null, null);
			for(Command com:commandList){
				result.append("�ظ�[" + com.getName() + "] ���Բ鿴   " + com.getDescription() + "<br>");
			}
			result.append("�ظ� �������ݿɻ���Զ��ظ�");
			return result.toString();
		}
		commandList = CommandDao.queryCommand(command, null);
		if(commandList.size()>0){
			List<Command_Content> contentList = commandList.get(0).getContentList();
			int index = new Random().nextInt(contentList.size());
			return contentList.get(index).getContent();
		}else{
			//��ȡͼ���Զ��ظ�
			return TuLingUtil.getTuLingAnswer(command);
		}
	}
}
