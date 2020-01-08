package com.baobaotao.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.baobaotao.domain.Topic;


public interface TopicDao {

	void addTopic(Topic topic);
}
