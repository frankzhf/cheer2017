package net.frank.cheer.demo.ch12;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	private static Logger logger = Logger.getLogger(Log4jTest.class);
	
	
	public static void main(String[] args) {
		System.out.println("Info Test");
		System.out.println("Debug Test");
		System.out.println("Warn Test");
		System.out.println("Error test");
		
		
		logger.info("Info Test");
		logger.debug("Debug Test");
		logger.warn("Warn Test");
		logger.error("Error test");
	}

}
