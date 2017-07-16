package net.frank.cheer.demo.ch21;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	public static void main(String[] args){
		Student s = new Student();
		s.setId("11189fdsfasdfjasfkasdfas");
		s.setName("zhangsan");
		
		Classroom cr = new Classroom();
		cr.setTitle("2017 weekend");
		s.setClassroom(cr);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		try {
			json = mapper.writeValueAsString(s);
		} catch (JsonProcessingException e) {
			
		}
		System.out.println(json);
		
		
		Student ss = null;
		try {
			ss = mapper.readValue(json, Student.class);
		} catch (IOException e) {
			
		}
		
		System.out.println(ss);
		
	}
}


class Student{
	private String id;
	private String name;
	private Classroom classroom;
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setClassroom(Classroom classroom){
		this.classroom = classroom;
	}
	
	public Classroom getClassroom(){
		return classroom;
	}
	
	public String toString(){
		return "Student [id=" + id + ",name="+name+",classroom="+classroom+ "]";
	}
}

class Classroom{
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Classroom [title=" + title + "]";
	}
}