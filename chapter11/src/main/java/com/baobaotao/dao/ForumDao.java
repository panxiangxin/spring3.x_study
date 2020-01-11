package com.baobaotao.dao;

import com.baobaotao.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pxx
 * Date 2020/1/11 14:34
 * @Description
 */
@Repository
public class ForumDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void addForumByNamedParams(final Forum forum) {
		final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES (:forumName,:forumDesc)";
		
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(forum);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	public void initDb() {
		String sql = "create table t_user(user_id int primary key,user_name varchar(60))";
		jdbcTemplate.execute(sql);
	}
	
	public void addForum(Forum forum) {
		String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES (?,?)";
		Object[] params = new Object[]{forum.getForumName(), forum.getForumDesc()};
		jdbcTemplate.update(sql,params);
		//jdbcTemplate.update(sql,params,new int[]{Types.VARCHAR,Types.VARBINARY});
	}
	//为了forum在内部类中使用 必须声明为final
	public void addForum1(final Forum forum) {
		 final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES (?,?)";
		 
//		jdbcTemplate.update(sql, new PreparedStatementSetter() {
//			public void setValues(PreparedStatement preparedStatement) throws SQLException {
//				preparedStatement.setString(1, forum.getForumName());
//				preparedStatement.setString(2, forum.getForumDesc());
//			}
//		});
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, forum.getForumName());
				preparedStatement.setString(2, forum.getForumDesc());
				return preparedStatement;
			}
		}, keyHolder);
		
		forum.setForumId(keyHolder.getKey().intValue());
	}
	
	public void addForums(final List<Forum> forums) {
		final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES (?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
				Forum forum = forums.get(i);
				preparedStatement.setString(1, forum.getForumName());
				preparedStatement.setString(2, forum.getForumDesc());
			}
			
			public int getBatchSize() {
				return forums.size();
			}
		});
	}
	
	public Forum getForum(final int forumId) {
		String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id = ?";
		final Forum forum = new Forum();
		jdbcTemplate.query(sql, new RowCallbackHandler() {
					public void processRow(ResultSet resultSet) throws SQLException {
						forum.setForumId(forumId);
						forum.setForumName(resultSet.getString("forum_name"));
						forum.setForumDesc(resultSet.getString("forum_desc"));
					}
				}, forumId);
		
		return forum;
	}
	
	public List<Forum> getForums(final int forumId, final int told) {
		
		String sql = "SELECT forum_id, forum_name,forum_desc FROM t_forum WHERE forum_id between ? and ?";
		final List<Forum> forums = new ArrayList<Forum>();
		
//		jdbcTemplate.query(sql, new Object[]{forumId, told}, new RowCallbackHandler() {
//			public void processRow(ResultSet resultSet) throws SQLException {
//				Forum forum = new Forum();
//				forum.setForumId(resultSet.getInt("forum_id"));
//				forum.setForumName(resultSet.getString("forum_name"));
//				forum.setForumDesc(resultSet.getString("forum_desc"));
//				forums.add(forum);
//			}
//		});
//
//		return forums;
		
		return jdbcTemplate.query(sql, new Object[]{forumId, told}, new RowMapper<Forum>() {
			public Forum mapRow(ResultSet resultSet, int i) throws SQLException {
				Forum forum = new Forum();
				forum.setForumId(resultSet.getInt("forum_id"));
				forum.setForumName(resultSet.getString("forum_name"));
				forum.setForumDesc(resultSet.getString("forum_desc"));
				return forum;
			}
		});
	}
	
	public int getForumNum(){
		String sql = "SELECT COUNT(*) FROM t_forum";
		return jdbcTemplate.queryForInt(sql);
	}
}
