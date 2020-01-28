package com.baobaotao.oxm.xstream;

import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/28 14:52
 * @Description
 */
public class XStreamSample {
	
	private static XStream xStream;
	
	static {
		xStream = new XStream(new DomDriver());
	}
	
	public static User getUser() {
		LoginLog loginLog = new LoginLog();
		loginLog.setIp("192.168.1.1");
		loginLog.setLoginDate(new Date());
		User user = new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.addLoginLog(loginLog);
		return user;
	}
	
	public static void objectToXML() throws FileNotFoundException {
		
		User user = getUser();
		FileOutputStream outputStream = new FileOutputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/XStreamSample.xml");
		
		xStream.toXML(user, outputStream);
	}
	public static void XMLToObject() throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/XStreamSample.xml");
		
		User user = (User) xStream.fromXML(inputStream);
		for (Object loginLog : user.getLogs()) {
			if (loginLog != null) {
				LoginLog log = (LoginLog)loginLog;
				System.out.println("访问ip:" + log.getIp());
				System.out.println("访问时间：" + log.getLoginDate());
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		XStreamSample.objectToXML();
		XStreamSample.XMLToObject();
	}
}
