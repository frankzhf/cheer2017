package net.frank.cheer.demo.ch06;

import java.util.Iterator;
import java.util.Map;

public class SystemTest {
	public static void main(String[] args){
		
		Map<String,String> sysMap = System.getenv();
		for(Iterator<String> it = sysMap.keySet().iterator();it.hasNext();){
			String key = it.next();
			System.out.println(key + ":" + sysMap.get(key));
		}
		
		
	}
}
