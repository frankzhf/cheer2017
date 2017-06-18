package net.frank.tiger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.management.ManagementFactory;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import net.frank.tiger.executor.SendScreenImg;

public class BroderCast {
	private static transient Logger log = Logger.getLogger(BroderCast.class);
	
	private static final String DEFAULT_PORT = "8002";
	
	public static void main(String[] args){
		Properties p = new Properties();
		try{
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("tiger.properties"));
		}catch(IOException e){
			log.error(e.getMessage(),e);
			System.exit(1);
		}
		String port = p.getProperty("tiger.port",DEFAULT_PORT);
		new BroderCast(port);
	}
	
	public BroderCast(String port){
		String name = ManagementFactory.getRuntimeMXBean().getName();
		log.info("RuntimeMXBean.name -> " + name);
		String pid = name.split("@")[0];
		File pidFile = new File("run/tiger.pid");
		if(pidFile.exists()){
			pidFile.delete();
		}
		RandomAccessFile raf = null;
		try {
			pidFile.createNewFile();
			raf = new RandomAccessFile(pidFile,"rw");
			raf.writeUTF(pid);
			raf.close();
		} catch (IOException e){
			log.error(e.getMessage(),e);
		} finally{
			try{
				if(raf!=null){
					raf.close();
				}
			}catch(IOException e){
				
			}
		}
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(new SendScreenImg(port));
		log.info("开始");
	}	
}