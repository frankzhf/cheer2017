package net.frank.monkey;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.frank.monkey.executor.ReceiveImages;
import org.apache.log4j.Logger;

public class ReceiveBroderCast {
	
	private static final String ENV_DEFINE = "monkey.properties";
	
	private static final String KEY_TIPER_IP = "tiger.ip";
	private static final String KEY_TIPER_PORT = "tiger.port";
	
	
	private static transient Logger log = Logger.getLogger(ReceiveBroderCast.class);
	public ExecutorService exector;

	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(ENV_DEFINE));
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			System.exit(1);
		}
		String tigerIp = p.getProperty(KEY_TIPER_IP);
		String tigerPort = p.getProperty(KEY_TIPER_PORT);
		new ReceiveBroderCast(tigerIp, tigerPort);
	}

	public ReceiveBroderCast(String tigerIp, String tigerPort) {
		this.exector = Executors.newFixedThreadPool(1);
		this.exector.execute(new ReceiveImages(tigerIp, tigerPort));
	}
}