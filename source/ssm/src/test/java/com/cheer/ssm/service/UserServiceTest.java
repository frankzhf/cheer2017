package com.cheer.ssm.service;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.ssm.domain.UserLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ @ContextConfiguration(name = "parent", locations = "classpath:spring/spring-context.xml") })
public class UserServiceTest {

	private transient Log log = LogFactory.getLog(getClass());

	@Autowired
	private UserService userService;

	@Test
	public void testQueryPage() {
		List<UserLog> result = userService.queryPage(1, 3);
		log.info("Varible [pageInfo] -> " + result);
		displayDetail(result);
		result = userService.queryPage(2, 3);
		log.info("Varible [pageInfo] -> " + result);
		displayDetail(result);
		result = userService.queryPage(3, 3);
		log.info("Varible [pageInfo] -> " + result);
		displayDetail(result);
		result = userService.queryPage(4, 3);
		log.info("Varible [pageInfo] -> " + result);
		displayDetail(result);
	}
	
	private void displayDetail(List<UserLog> result){
		for(Iterator<UserLog> it= result.iterator();it.hasNext();){
			UserLog item = it.next();
			log.info("Varible [item] -> " + item);
		}
	}
	
}
