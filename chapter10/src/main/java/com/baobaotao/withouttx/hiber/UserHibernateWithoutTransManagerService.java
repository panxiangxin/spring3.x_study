package com.baobaotao.withouttx.hiber;

import com.baobaotao.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 * @author pxx
 * Date 2020/1/10 11:27
 * @Description
 */
@Service("hiberService")
public class UserHibernateWithoutTransManagerService {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void addScore(String userName,int toAdd){
		User user = hibernateTemplate.get(User.class,userName);
		user.setScore(user.getScore() + toAdd);
		hibernateTemplate.update(user);
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("hiberWithoutTx.xml");
		
		UserHibernateWithoutTransManagerService service = (UserHibernateWithoutTransManagerService) applicationContext.getBean("hiberService");
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		
		BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
		
		System.out.println("autoCommit:" + basicDataSource.getDefaultAutoCommit());
		
		jdbcTemplate.execute("INSERT INTO user_example(user_name,password,score,last_login_time) " +
									 "VALUES ('tom','123456','10','1111')");
		
		service.addScore("tom",20);
		
		int score = jdbcTemplate.queryForInt("SELECT score FROM user_example WHERE user_name = 'tom'");
		System.out.println("score:" + score);
		jdbcTemplate.execute("DELETE FROM user_example WHERE user_name='tom'");
	}
}
