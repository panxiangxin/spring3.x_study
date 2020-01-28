package com.baobaotao.oxm.xstream.objectstreams;

import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

import java.io.*;
import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/28 19:11
 * @Description
 */
public class ObjectStreamSample {
		private static XStream xStream;
		
		static {
			xStream = new XStream();
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
	
	
	public User xmlToObject() throws IOException, ClassNotFoundException {
		FileReader fileReader = new FileReader("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/ObjectStreamSample.xml");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ObjectInputStream inputStream = xStream.createObjectInputStream(bufferedReader);
		User user = (User) inputStream.readObject();
		return user;
	}
	
	public void ObjectToXml() throws IOException {
		PrintWriter writer = new PrintWriter("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/ObjectStreamSample.xml");
		User user = getUser();
		
		PrettyPrintWriter prettyPrintWriter = new PrettyPrintWriter(writer);
		ObjectOutputStream outputStream = xStream.createObjectOutputStream(prettyPrintWriter);
		
		outputStream.writeObject(user);
		outputStream.close();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectStreamSample streamSample = new ObjectStreamSample();
		
		streamSample.ObjectToXml();
		User user = streamSample.xmlToObject();
		for (Object log : user.getLogs()) {
			if (log != null) {
				LoginLog loginLog = (LoginLog)log;
				System.out.println("访问IP: " + loginLog.getIp());
				System.out.println("访问时间: " + loginLog.getLoginDate());
			}
		}
	}
}
