package com.cheer.ssm.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", 
				locations = "classpath:spring/spring-context.xml")
		})
public class LoginServiceTest {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private LoginService loginService;
	
	@Test
	public void testInitTestData(){
		log.info(loginService.login("admin","123456", "127.0.0.1"));
		log.info("Test finished!");
	}
}
