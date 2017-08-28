package com.cheer.mini.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MiniServletContextListener implements ServletContextListener {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.debug("Servlet context Initialized....");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("Alert! Our mini will closing!");
	}

}
