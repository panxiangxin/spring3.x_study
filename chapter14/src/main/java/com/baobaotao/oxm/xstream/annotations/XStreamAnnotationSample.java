package com.baobaotao.oxm.xstream.annotations;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/28 16:38
 * @Description
 */
public class XStreamAnnotationSample {
	private static XStream xStream;
	
	static {
		xStream = new XStream(new DomDriver());
		//实现该方法 判断要转换的类型
		xStream.processAnnotations(User.class);
		xStream.processAnnotations(LoginLog.class);
		//自动加载注解Bean
		xStream.autodetectAnnotations(true);
		
	}
	
	// 初始化转换对象
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}
	
	public static void objectToXML() throws FileNotFoundException {
		User user = getUser();
		FileOutputStream outputStream = new FileOutputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/XStreamAnnotationSample.xml");
		OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
		xStream.toXML(user, writer);
	}
	
	public static User xmlToObject()throws Exception{
		FileInputStream fis = new FileInputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/XStreamAnnotationSample.xml");
		InputStreamReader reader = new InputStreamReader(fis, Charset.forName("UTF-8"));
		User user = (User) xStream.fromXML(fis);
		for(Object log : user.getLogs()){
			if(log!=null){
				LoginLog loginLog = (LoginLog) log;
				System.out.println("访问IP: " + loginLog.getIp());
				System.out.println("访问时间: " + loginLog.getLoginDate());
			}
		}
		return user;
	}
	
	
	public static void main(String[] args) throws Exception {
		objectToXML();
		xmlToObject();
	}
}
