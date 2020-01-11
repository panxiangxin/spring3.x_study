package com.baobaotao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import com.baobaotao.domain.Post;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration
@Transactional
public class TestPostDao{
	
	@Autowired
	private PostDao postDao;
	
    @Test
	public void testAddPost() throws Throwable{
		Post post = new Post();
		post.setUserId(2);
		ClassPathResource res = new ClassPathResource("temp1.jpg");
		byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());	
		post.setPostAttach(mockImg);
		post.setPostText("测试帖子的内容");
		postDao.addPost(post);
		System.out.println("okokookokokok");
	}
	
}
