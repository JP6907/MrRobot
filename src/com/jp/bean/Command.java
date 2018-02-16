package com.jp.bean;

import java.util.List;

/**
 * 指令类
 * @author Administrator
 *
 */
public class Command {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 命令名字
	 */
	private String name;
	/**
	 * 命令描述
	 */
	private String description;
	/**
	 * 回复内容列表
	 */
	private List<Command_Content> contentList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Command_Content> getContentList() {
		return contentList;
	}
	public void setContentList(List<Command_Content> contentList) {
		this.contentList = contentList;
	}
}
