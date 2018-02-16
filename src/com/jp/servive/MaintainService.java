package com.jp.servive;

import java.util.ArrayList;
import java.util.List;

import com.jp.dao.CommandDao;
import com.jp.dao.MessageDao;

/**
 * 维护相关业务功能
 * @author Administrator
 *
 */
public class MaintainService {
	/**
	 * 删除单条
	 * @param commandId
	 * @param contentId
	 */
	public void deleteOne(String commandId, String contentId){
		if(commandId!=null&&!commandId.equals("") && contentId!=null&&!contentId.equals("")){
			CommandDao.deleteOne(Integer.valueOf(commandId), Integer.valueOf(contentId));
		}
	}
	/**
	 * 批量删除
	 * @param ids 内容 表的id数组
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
	 * 添加指令操作
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
	 * 修改指令
	 * @param commandIdString 指令ID
	 * @param contentIdString 内容ID
	 * @param oldDescription 旧的指令描述 description
	 * @param newDescription 新的指令描述 description
	 * @param oldContent 旧的指令回复内容 content
	 * @param newContent 新的指令回复内容 content
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
