package com.jp.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;

/**
 * Mybatis ��ʽ
 * �������ݿ���
 * @author Administrator
 *
 */
public class DBAccess {
	/**
	 * ��ȡ���ݿ�Ự���� SqlSession
	 * @return SqlSession����
	 * @throws IOException
	 */
	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader = Resources.getResourceAsReader("com/jp/config/Configuration.xml");
		//ͨ�������ļ�����SqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ��SqlSessionFactory��ȡSqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
