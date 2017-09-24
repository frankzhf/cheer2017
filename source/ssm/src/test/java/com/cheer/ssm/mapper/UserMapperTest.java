package com.cheer.ssm.mapper;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.ssm.domain.User;
import com.cheer.ssm.helper.UserHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", 
				locations = "classpath:spring/spring-context.xml")
		})
public class UserMapperTest {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Test
	public void testFindByUserName(){
		User user= userMapper.findForUserName("admin");
		log.info("Varrible [user] -> " + user);
		user= userMapper.findForUserName("admin1");
		log.info("Varrible [user] -> " + user);
	}
	
	@Test
	public void testInert(){
		User user= new User();
		user.setUserName("frank");
		user.setCredits(0);
		user.setPassword("123456");
		
		userMapper.insert(user);
		
		
	}
	

	@Test
	public void testGet(){
		User user= userMapper.get(2L);
		log.info("Varrible [user] -> " + user);
		user= userMapper.get(3L);
		log.info("Varrible [user] -> " + user);
	}
	
	
	@Test
	public void testUpdate(){
		User user= userMapper.get(2L);
		log.info("Varrible [user] -> " + user);
		user.setPassword("654321");
		userMapper.update(user);
		user= userMapper.get(2L);
		log.info("Varrible [user] -> " + user);
	}
	
	@Test
	public void testDelete(){
		User user= userMapper.get(2L);
		log.info("Varrible [user] -> " + user);
		userMapper.delete(user);
		user= userMapper.get(2L);
		log.info("Varrible [user] -> " + user);
		
	}
	
	@Test
	public void testFind(){
		User param = new User();
		
		param.setUserName("admin");
		List<User> result  = userMapper.find(param);
		log.info("Varrible [result] -> " + result);
		
		
		param.setPassword("123456");
		result  = userMapper.find(param);
		log.info("Varrible [result] -> " + result);
		
		param.setPassword("654321");
		result  = userMapper.find(param);
		log.info("Varrible [result] -> " + result);
		
	}
	
	@Test
	public void testFindHelper(){
		UserHelper userHelper = userMapper.findHelper(1L);
		log.info("Varrible [userHelper] -> " + userHelper);
	}
	
}
