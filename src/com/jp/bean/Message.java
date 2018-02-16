package com.jp.bean;

/**
 * 消息实体类
 * @author Administrator
 *
 */
public class Message {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 指令
	 */
	private String command;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 内容
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
