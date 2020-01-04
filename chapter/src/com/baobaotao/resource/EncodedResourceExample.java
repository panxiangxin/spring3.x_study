package com.baobaotao.resource;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class EncodedResourceExample {
	
	public static void main(String[] args) throws Throwable {
		Resource resource = new ClassPathResource("conf/file1.txt");
		EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
		String content = FileCopyUtils.copyToString(encodedResource.getReader());
		System.out.println(content);
		
	}
}
