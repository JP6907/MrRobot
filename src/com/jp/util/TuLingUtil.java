package com.jp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 通过图灵接口获取智能问答机器人的回答
 * @author Administrator
 *
 */
public class TuLingUtil {
	/**
	 * 获取图灵机器人的回答
	 * @param question 问题
	 * @throws UnsupportedEncodingException
	 * @throws IOException 
	 * @return 回答
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
	
	        // 取得输入流，并使用Reader读取 
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
		     // 断开连接 
		}
        //获取的原始数据格式为：  {"code":100000,"text":"阴沉沉的，一点都不好。"}
        //切割后为    ：阴沉沉的，一点都不好。

        return sb.substring(23, sb.length()-2);
       
	}
}
