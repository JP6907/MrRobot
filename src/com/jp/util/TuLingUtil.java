package com.jp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * ͨ��ͼ��ӿڻ�ȡ�����ʴ�����˵Ļش�
 * @author Administrator
 *
 */
public class TuLingUtil {
	/**
	 * ��ȡͼ������˵Ļش�
	 * @param question ����
	 * @throws UnsupportedEncodingException
	 * @throws IOException 
	 * @return �ش�
	 */
	public static String getTuLingAnswer(String question){
		StringBuffer sb = new StringBuffer(); 
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		try {
			String APIKEY = "e7a1447ed2182d57758ca845e5a0f36e"; 
	        String INFO = URLEncoder.encode(question, "utf-8"); 
	        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO; 
	        URL getUrl = new URL(getURL); 
	        connection = (HttpURLConnection) getUrl.openConnection(); 
	        connection.connect(); 
	
	        // ȡ������������ʹ��Reader��ȡ 
	        reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8")); 
	        String line = ""; 
        while ((line = reader.readLine()) != null) { 
            sb.append(line); 
        } 
       
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			connection.disconnect(); 
			 try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		     // �Ͽ����� 
		}
        //��ȡ��ԭʼ���ݸ�ʽΪ��  {"code":100000,"text":"�������ģ�һ�㶼���á�"}
        //�и��Ϊ    ���������ģ�һ�㶼���á�

        return sb.substring(23, sb.length()-2);
       
	}
}
