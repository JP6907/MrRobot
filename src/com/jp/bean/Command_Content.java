package com.jp.bean;

/**
 * �ظ�������
 * @author Administrator
 *
 */
public class Command_Content {
	/**
	 * ���
	 */
	private int id;
	/**
	 * �ظ�����
	 */
	private String content;
	/**
	 * �ظ����ݶ�Ӧ��ָ��
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
