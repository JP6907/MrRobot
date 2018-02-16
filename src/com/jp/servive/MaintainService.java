package com.jp.servive;

import java.util.ArrayList;
import java.util.List;

import com.jp.dao.CommandDao;
import com.jp.dao.MessageDao;

/**
 * ά�����ҵ����
 * @author Administrator
 *
 */
public class MaintainService {
	/**
	 * ɾ������
	 * @param commandId
	 * @param contentId
	 */
	public void deleteOne(String commandId, String contentId){
		if(commandId!=null&&!commandId.equals("") && contentId!=null&&!contentId.equals("")){
			CommandDao.deleteOne(Integer.valueOf(commandId), Integer.valueOf(contentId));
		}
	}
	/**
	 * ����ɾ��
	 * @param ids ���� ���id����
	 */
	public void deleteBatch(String[] ids){
		if(ids!=null&&ids.length>0){
			List<Integer> idList = new ArrayList<Integer>();
			for(String id:ids){
				idList.add(Integer.valueOf(id));
			}
			CommandDao.deleteBatch(idList);
		}
	}
	/**
	 * ���ָ�����
	 * @param command
	 * @param description
	 * @param content
	 */
	public void addCommand(String command, String description, String content){
		if(command!=null&&!command.trim().equals("")){
			if(description!=null&&!description.trim().equals("")){
				if(content!=null&&!content.trim().equals("")){
					CommandDao.addCommand(command, description, content);
				}
			}
		}
	}
	/**
	 * �޸�ָ��
	 * @param commandIdString ָ��ID
	 * @param contentIdString ����ID
	 * @param oldDescription �ɵ�ָ������ description
	 * @param newDescription �µ�ָ������ description
	 * @param oldContent �ɵ�ָ��ظ����� content
	 * @param newContent �µ�ָ��ظ����� content
	 */
	public void fixCommand(String commandIdString, String contentIdString, 
			String oldDescription, String newDescription, String oldContent, String newContent){
		int commandId = Integer.valueOf(commandIdString);
		int contentId = Integer.valueOf(contentIdString);
		if(!oldDescription.equals(newDescription)){
			CommandDao.fixDescription(commandId, newDescription);
		}
		if(!oldContent.equals(newContent)){
			CommandDao.fixContent(contentId, newContent);
		}
		
	}
}
