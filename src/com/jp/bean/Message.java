package com.jp.bean;

/**
 * ��Ϣʵ����
 * @author Administrator
 *
 */
public class Message {
	/**
	 * ���
	 */
	private int id;
	/**
	 * ָ��
	 */
	private String command;
	/**
	 * ����
	 */
	private String description;
	/**
	 * ����
	 */
	private String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDscription() {
		return description;
	}
	public void setDscription(String dscription) {
		this.description = dscription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
