package net.frank.cheer.demo.ch12;

import java.util.Calendar;

import net.frank.cheer.demo.Log4jSupport;

public class Log4jDemo extends Log4jSupport {
	
	public String toString(){
		logger.info("Info Test");
		logger.debug("Debug Test");
		logger.warn("Warn Test");
		logger.error("Error test");
		return super.toString();
	}
	
	
	public static void main(String[] args){
		Log4jDemo demo = new Log4jDemo();
		System.out.println(demo);
		System.out.println(demo);
		System.out.println(demo);
		System.out.println(demo);
		
		Calendar c = Calendar.getInstance(); // Single
		
		Country country = Country.getInstance();

		
		
		People p0 = new People();
		p0.setName("zhangshan");
		p0.setCountry(country);
		
		
		Country country1 = Country.getInstance();
		
		

		People p1 = new People();
		p1.setName("lisi");
		p1.setCountry(country1);
		
		People p2 = new People();
		p2.setName("wangwu");
		p2.setCountry(country1);
		
	}
}

class People{
	private String name;
	private Country country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}

class Country{
	private String title;
	private String name;
	
	static Country instance = new Country();
	
	public static Country getInstance(){
		if(instance == null){
			instance = new Country();
		}
		return instance;
	}
	
	private Country(){
		this.title = "Republic of China";
		this.name = "China";
	}
	
	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	
	
	
}