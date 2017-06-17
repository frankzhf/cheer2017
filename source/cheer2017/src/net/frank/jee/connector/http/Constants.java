package net.frank.jee.connector.http;

import org.apache.tomcat.util.PropertiesUtil;

public final class Constants {
  public static final String WEB_ROOT = PropertiesUtil.
		  getProperties("jee").getProperty("web.root");
    
  public static final String Package = "net.frank.jee.connector.http";
  public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
  public static final int PROCESSOR_IDLE = 0;
  public static final int PROCESSOR_ACTIVE = 1;
}
