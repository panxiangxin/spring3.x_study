package com.baobaotao.nestcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author pxx
 * Date 2020/1/10 13:41
 * @Description
 */
@Service("scoreUserService")
public class ScoreService extends BasicService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addScore(String userName, int toAdd) {
		String sql = "UPDATE user_example u SET u.score = u.score + ? WHERE user_name =?";
		jdbcTemplate.update(sql, toAdd, userName);
	}
}
