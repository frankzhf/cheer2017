package com.cheer.ssm.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.cheer.ssm.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", 
				locations = "classpath:spring/spring-context-dao.xml")
		})
public class UserDaoTest {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserDao userDao;
	
	
	@Before
	public void setup(){
		log.info("setup triggered!");
	}
	
	@After
	public void shutdown(){
		log.info("shutdown triggered!");
		
	}
	
	@Test
	public void testInsert(){
		User exists = userDao.findForUserName("admin");
		Assert.notNull(exists);
	}
	
	
}
