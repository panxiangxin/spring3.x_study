package com.baobaotao.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) //基于Junit4的Spring测试框架
@ContextConfiguration(locations= {"/applicationContext.xml"}) //②启动Spring容器
public class TestUserService {
	
	//注入Spring容器中的Bean
	@Autowired
	private UserService userService;
	//标注测试方法
	@Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
		assertTrue(!b2);
	}
	@Test
	public void findUserByUserName() {
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}
	@Test
	public void testAddLoginLog() {
		User user = userService.findUserByUserName("admin");
		user.setUserId(1);
		user.setUserName("admin");
		user.setLastIp("192.168.12.7");
		user.setLastVisit(new Date());
		userService.loginSuccess(user);
	}

}
