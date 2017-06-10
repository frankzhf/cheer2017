package net.frank.cheer.demo.ch15;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(
				PropertiesTest.class.getResourceAsStream("test.properties"));
		
		System.out.println(p.get("cheer.project"));
		System.out.println(p.get("cheer.teacher"));
		
		
		
	}

}
