package net.frank.cheer.demo.ch07f;

import java.util.Date;

public class OOPBaseTest {
	public static void main(String[] args){
		Person s = new Student();
		//s.printInfo();
		//s.id = "320105xxxxxxxxxxxxx";
		s.setId("320105xxxxxxxxxxxxx");
		s.setName("wang wu");
		s.setBirthday( new Date());
		//s.printInfo();
		
		
		Person ss = new Student();
		ss.setId("320106xxxxxxxxxxxxx");
		ss.setName("zhao lu");
		ss.setBirthday( new Date());
		//ss.printInfo();
		
		
		Person sss = new Teacher();
		sss.setId("320106xxxxxxxxxxxxx");
		sss.setName("zhang shang");
		sss.setBirthday( new Date());
		
		Student _s = (Student) s;
		
		
		sss.process();
		ss.process();
		s.process();
		
		
	}
	
	
}

abstract class Person{
	private String id;
	private String name;
	private Date birthday;
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Date getBirthday(){
		return birthday;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	public void printInfo(){
		System.out.println("class:" + getClass().getName());
		System.out.println("Id : " + getId());
		System.out.println("name : " + getName());
		System.out.println("birthday : " + getBirthday());
	}
	
	abstract void process();
}

class Teacher extends Person{
	
	public void teach(){
		printInfo();
		System.out.println("start teach.....");
	}
	
	@Override
	void process() {
		teach();
	}
	
}


class Student extends Person{
	
	
	public void study(){
		printInfo();
		System.out.println("start study.....");
	}
	
	
	@Override
	void process() {
		study();
	}
	
	
	
}
