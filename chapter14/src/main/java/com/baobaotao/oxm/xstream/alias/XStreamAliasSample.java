package com.baobaotao.oxm.xstream.alias;

import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/28 15:45
 * @Description
 */
public class XStreamAliasSample {
	
	private static XStream xStream;
	
	static {
		xStream = new XStream(new DomDriver());
		xStream.alias("loginLog", LoginLog.class);
		xStream.alias("user", User.class);
		
		xStream.aliasField("id", User.class, "userId");
		xStream.aliasAttribute(LoginLog.class, "userId", "id");
		xStream.useAttributeFor(LoginLog.class, "userId");
		
		xStream.addImplicitCollection(User.class, "logs");
	}
	
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
	
	/**
	 * JAVA对象转化为XML
	 */
	public static void objectToXml()throws Exception{
		User user = getUser();
		FileOutputStream fs = new FileOutputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/XStreamAliasSample.xml");
		xStream.toXML(user, fs);
	}
	
	/**
	 * XML转化为JAVA对象
	 */
	public static User xmlToObject()throws Exception{
		FileInputStream fis = new FileInputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/XStreamAliasSample.xml");
		User u = (User) xStream.fromXML(fis);
		for(Object log1 : u.getLogs()){
			if(log1!=null){
				LoginLog log = (LoginLog)log1;
				System.out.println("访问IP: " + log.getIp());
				System.out.println("访问时间: " + log.getLoginDate());
			}
		}
		return u;
	}
	
	public static void main(String[] args) throws Exception {
		objectToXml();
		xmlToObject();
	}
}
