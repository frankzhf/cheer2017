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

import com.cheer.ssm.domain2.MyStudent;
import com.cheer.ssm.domain2.MyStudentExample;
import com.cheer.ssm.helper.UserLogHelper;
import com.cheer.ssm.mapper2.MyStudentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", 
				locations = "classpath:spring/spring-context.xml")
		})
public class UserLogMapperTest {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserLogMapper userLogMapper;
	
	@Autowired
	private MyStudentMapper studentMapper;
	
	@Test
	public void testGet(){
		UserLogHelper logHelper = userLogMapper.get(4L);
		log.info("Varible [logHelper] -> " + logHelper);
	}
	@Test
	public void testStudentMapperFindExample(){
		MyStudentExample example = new MyStudentExample();
		
		example.createCriteria().andNameEqualTo("张三")
			.andSexEqualTo((byte)0);
		List<MyStudent> result = studentMapper.selectByExample(example);
		
		log.info("Varible [result] -> " + result);
		
		
	}
	
}
