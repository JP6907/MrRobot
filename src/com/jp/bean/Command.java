package com.jp.bean;

import java.util.List;

/**
 * ָ����
 * @author Administrator
 *
 */
public class Command {
	/**
	 * ���
	 */
	private int id;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * ��������
	 */
	private String description;
	/**
	 * �ظ������б�
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
