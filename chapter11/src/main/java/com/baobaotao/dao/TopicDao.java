package com.baobaotao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pxx
 * Date 2020/1/11 14:38
 * @Description
 */
@Repository
public class TopicDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public double getReplyRate(int userId) {
		String sql = "SELECT topic_view,plies FROM t_topic WHERE user_id = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<Double>() {
			public Double mapRow(ResultSet resultSet, int i) throws SQLException {
				int replies = resultSet.getInt("plies");
				int views = resultSet.getInt("topic_views");
				
				if (views > 0) {
					return (double) replies / views;
				}else {
					return 0.0;
				}
			}
		});
	}
	public int getUserTopicNum(final int userId) {
		String sql = "{call P_GET_TOPIC_NUM(?,?)}";
		//方式1
/*		Integer num = jdbcTemplate.execute(sql,
				new CallableStatementCallback<Integer>() {
					public Integer doInCallableStatement(CallableStatement cs)
							throws SQLException, DataAccessException {
						cs.setInt(1, userId);
						cs.registerOutParameter(2, Types.INTEGER);
						cs.execute();
						return cs.getInt(2);
					}
				});
		return num;*/
		
		//方式2
		CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(sql);
		fac.addParameter(new SqlParameter("userId", Types.INTEGER));
		fac.addParameter(new SqlOutParameter("topicNum",Types.INTEGER));
		Map<String,Integer> paramsMap = new HashMap<String,Integer>();
		paramsMap.put("userId",userId);
		CallableStatementCreator csc = fac.newCallableStatementCreator (paramsMap);
		Integer num = jdbcTemplate.execute(csc,new CallableStatementCallback<Integer>(){
			public Integer doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {
				cs.execute();
				return cs.getInt(2);
			}
		});
		return num;
	}

}
