package net.frank.commons.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertiesUtil {
	
	private static Object locker = new Object();
	
	private static Map<String,Properties> cache =  new HashMap<String,Properties>();
	
	//private static final String BATCH_PROPERTIES_KEY = "system";
	
	//public static final Properties getBatchProperties(){
	//	return getRetailerProperties(BATCH_PROPERTIES_KEY);
	//}
	
	public static final Properties getProperties(String bandler){
		synchronized (locker) {
			if(cache.get(bandler)==null){
				Properties p = new Properties();
				try {
					p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(bandler +".properties"));
					cache.put(bandler, p);
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(),e);
				};
			}
			return cache.get(bandler);
		}	
	}
	
	public static void clear(){
		synchronized (locker) {
			cache.clear();
		}
	}
}
