package net.frank.cheer.demo.ch17;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenTypeTest {
	
	public static void main(String[] args){
		//jdk 1.4
		//List data = new ArrayList();
		//data.add(Object obj)
		// Integer = int
		// int i =10;
		// data.add(new Integer(i))
		// Object obj
		// 
		List<Person> data = new ArrayList<Person>();
		Student s = new Student();
		Teacher t = new Teacher();
		//Person p = new Person();
		
		//data.add(p);
		data.add(s);
		data.add(t);
		
		
	}
	
}

abstract class Person implements Serializable{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


class Student extends Person{

}

class Teacher extends Person{
	
}
