package net.frank.yangtes.modules.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:spring/spring-context.xml")
		})
public class SpringAppContextSetupBaseTester {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	public void setUp() {
		
	}
	@Test
	public void testInit(){
		log.info("init success");
	}
}
