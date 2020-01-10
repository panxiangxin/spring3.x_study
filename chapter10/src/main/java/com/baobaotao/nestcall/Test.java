package com.baobaotao.nestcall;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author pxx
 * Date 2020/1/10 13:52
 * @Description
 */
public class Test {
	public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicatonContext-nestcall.xml");
	UserService service = (UserService) ctx.getBean("userService");
	
	JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
	//插入一条记录，初始分数为10
	jdbcTemplate.execute("INSERT INTO user_example(user_name,password,score,last_login_time) VALUES('tom','123456',10, '1111')");
	
	//调用工作在无事务环境下的服务类方法,将分数添加20分
	System.out.println("before userService.logon method...");
	service.logon("tom");
	System.out.println("after userService.logon method...");
	
	jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
}
}
