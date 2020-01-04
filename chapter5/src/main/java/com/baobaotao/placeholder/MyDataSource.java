package com.baobaotao.placeholder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDataSource {

	
	@Value("${driverClassName}")
	private String driveClassName;
	
	@Value("${url}")
	private String url;
	
	@Value("${userName}")
	private String userName;
	
	@Value("${password}")
	private String password;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
}
}