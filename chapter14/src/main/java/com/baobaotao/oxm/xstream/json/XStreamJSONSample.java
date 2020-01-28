package com.baobaotao.oxm.xstream.json;

import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/28 19:32
 * @Description
 */
public class XStreamJSONSample {
	private static XStream xStream;
	
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}
	//未格式化JSON
	public static void toJsonByJettisonMappedXmlDriver()throws Exception {
		User user = getUser();
		FileOutputStream outputSteam = new FileOutputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/JettisonMappedSample.json");
		OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));
		xStream = new XStream(new JettisonMappedXmlDriver());
		xStream.setMode(XStream.NO_REFERENCES);
		xStream.alias("user", User.class);
		xStream.toXML(user,writer);
	}
	//格式化JSON
	public static void toJsonByJsonHierarchicalStreamDriver()throws Exception {
		User user = getUser();
		FileOutputStream outputSteam = new FileOutputStream("D:/Users/www72/IdeaProjects/spring3.x_study/chapter14/out/JsonByJsonHierarchicalSample.json");
		OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));
		xStream = new XStream(new JsonHierarchicalStreamDriver());
		xStream.alias("user", User.class);
		xStream.toXML(user,writer);
	}
	
	public static void main(String[] args) throws Exception{
		toJsonByJettisonMappedXmlDriver();
		toJsonByJsonHierarchicalStreamDriver();
		/*User u = jsonToObject();
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("访问IP: " + log.getIp());
				System.out.println("访问时间: " + log.getLoginDate());
			}
		}*/
	}
}
