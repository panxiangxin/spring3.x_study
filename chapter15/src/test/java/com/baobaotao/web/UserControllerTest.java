package com.baobaotao.web;

import com.baobaotao.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

/**
 * @author pxx
 * Date 2020/2/2 12:42
 * @Description
 */
public class UserControllerTest {
	
	
	@Test
	public void handler41() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "tom");
		form.add("password", "123456");
		form.add("age", "45");
		restTemplate.postForLocation(
				"http://localhost:8080/user/handler41.html", form);
	}
	
	@Test
	public void handler42() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		byte[] response = restTemplate.postForObject(
				"http://localhost:8080/user/handler42/{itemId}.html", null, byte[].class, "1233"
		);
		
		Resource outFile = new FileSystemResource("d:/image_copy.jpg");
		FileCopyUtils.copy(response,outFile.getFile());
	}
	
	@Test
	public void testhandler51() {
		RestTemplate restTemplate = buildRestemplate();
		User user = new User();
		user.setUserId("123");
		user.setUserName("tom");
		user.setPassword("1234");
		user.setRealName("汤姆");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.valueOf("application/xml;UTF_8"));
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		
		HttpEntity<User> entity = new HttpEntity<User>(user, httpHeaders);
		ResponseEntity<User> responseEntity = restTemplate.exchange(
				"http://localhost:8080/user/handler51.html",
				HttpMethod.POST,
				entity, User.class
		);
		
		User user1 = responseEntity.getBody();
		Assert.assertNotNull(user1);
		System.out.println("user1:" + user1);
		Assert.assertEquals("1000",user1.getUserId());
		
	}
	
	private RestTemplate buildRestemplate() {
		RestTemplate restTemplate = new RestTemplate();
		
		XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
		xStreamMarshaller.setStreamDriver(new StaxDriver());
		xStreamMarshaller.setAnnotatedClasses(new Class[]{User.class});
		
		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
		xmlConverter.setMarshaller(xStreamMarshaller);
		xmlConverter.setUnmarshaller(xStreamMarshaller);
		restTemplate.getMessageConverters().add(xmlConverter);
		
		MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();
		restTemplate.getMessageConverters().add(jsonConverter);
		return restTemplate;
	}
	
	
	@Test
	public void handler82() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		
		form.add("userName", "tom");
		form.add("password", "1234");
		form.add("userId", "12");
		form.add("birthday", "1980-01-01");
		form.add("salary", "4,50000");
		
		String html = restTemplate.postForObject(
				"http://localhost:8080/user/handler82.html", form, String.class
		);
		System.out.println(html);
//		Assert.assertNotNull(html);
//		Assert.assertTrue(html.contains("tom"));
	}
}
