package com.jp.bean;

/**
 * 回复的内容
 * @author Administrator
 *
 */
public class Command_Content {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 回复内容
	 */
	private String content;
	/**
	 * 回复内容对应的指令
	 */
	private int command_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommand_id() {
		return command_id;
	}
	public void setCommand_id(int command_id) {
		this.command_id = command_id;
	}
}
