package com.baobaotao.mixdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author www72
 */
@Service("scoreService")
public class ScoreService extends BaseService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd) {
        String sql = "UPDATE user_example u SET u.score = u.score + ? WHERE user_name =?";
        jdbcTemplate.update(sql, toAdd, userName);
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        System.out.println("[scoreUserService.addScore]激活连接数量："+basicDataSource.getNumActive());
    }
}
