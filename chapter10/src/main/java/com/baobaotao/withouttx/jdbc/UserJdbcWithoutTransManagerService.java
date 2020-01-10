package com.baobaotao.withouttx.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author pxx
 * Date 2020/1/9 16:20
 * @Description
 */
@Service("userService")
public class UserJdbcWithoutTransManagerService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addScore(String userName,int toAdd){
		String sql="UPDATE t_user u SET u.credits=u.credits+? Where user_name=?";
		jdbcTemplate.update(sql,toAdd,userName);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcWithoutTx.xml");
		UserJdbcWithoutTransManagerService service = (UserJdbcWithoutTransManagerService) ctx.getBean("userService");
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
		
		System.out.println("autoCommit:" + basicDataSource.getDefaultAutoCommit());
		
		jdbcTemplate.execute("INSERT INTO t_user(user_name,password,credits,last_visit) " +
									 "VALUES ('tom','123456','10','2020-10-24')");
		
		service.addScore("tom",20);
		
		int credit = jdbcTemplate.queryForInt("SELECT credits FROM t_user WHERE user_name = 'tom'");
		System.out.println("credit:" + credit);
		jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
	}
}
