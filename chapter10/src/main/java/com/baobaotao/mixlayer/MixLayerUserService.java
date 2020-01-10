package com.baobaotao.mixlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pxx
 * Date 2020/1/10 12:36
 * @Description
 */
@Controller
public class MixLayerUserService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/login.do")
	@Transactional
	public String logon(String userName, String password) {
		if (isRightUser(userName, password)) {
			String sql = "UPDATE user_example u SET u.score = u.score + ? WHERE user_name = ?";
			jdbcTemplate.update(sql,20,userName);
			return "success";
		}else {
			return "fail";
		}
	}
	
	private boolean isRightUser(String userName, String password) {
		return true;
	}
}
