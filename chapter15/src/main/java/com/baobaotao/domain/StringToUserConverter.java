package com.baobaotao.domain;


import org.springframework.core.convert.converter.Converter;

/**
 * @author pxx
 * Date 2020/2/2 14:37
 * @Description
 */
public class StringToUserConverter implements Converter<String,User> {
	public User convert(String s) {
		User user = new User();
		if (s != null) {
			String[] items = s.split(":");
			user.setUserName(items[0]);
			user.setPassword(items[1]);
			user.setRealName(items[2]);
		}
		
		return user;
	}
}
