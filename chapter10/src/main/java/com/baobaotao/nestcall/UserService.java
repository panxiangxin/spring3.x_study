package com.baobaotao.nestcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author pxx
 * Date 2020/1/10 13:40
 * @Description
 */
@Service("userService")
public class UserService extends BasicService{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ScoreService scoreService;
	
	public void logon(String userName) {
		System.out.println("before userService.updateLastLogonTime...");
		updateLastLogonTime(userName);
		System.out.println("after userService.updateLastLogonTime...");
		
		System.out.println("before scoreService.addScore...");
		scoreService.addScore(userName, 20);
		System.out.println("after scoreService.addScore...");
		
	}
	
	public void updateLastLogonTime(String userName) {
		String sql = "UPDATE user_example u SET u.last_login_time = ? WHERE user_name =?";
		jdbcTemplate.update(sql, 1111, userName);
	}
}
