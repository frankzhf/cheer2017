package net.frank.cheer.demo.ch07;

import java.util.Date;
import java.util.Scanner;

public class OOPDemo {
	
	
	public static void main(String[] args) {
		String name = "guocheng";
		int age = 28;
		Date birthday = new Date();
		System.out.println("Student name's " + name);
		System.out.println("Student age's  " + age);
		
		String name1 = "guocheng";
		int age1 = 28;
		
		System.out.println("Student name's " + name1);
		System.out.println("Student age's  " + age1);
		
		String[] studentName = new String[100];
		int[] studentAge = new int[100];
		Date[] studentBirthday = new Date[100];
		
		Scanner scanner = new Scanner(System.in);
		int i=0;
		while(scanner.hasNext()){
			System.out.print("enter student name:");
			studentName[i] = scanner.next();
			System.out.print("enter student age:");
			studentAge[i] = scanner.nextInt();	
			
			//students[i].name = scanner.next();
			
			
		}
		/***
		Student[] students = new Student[100];
		int studentIndex = 0;
		while(true){
			
			students[i] = new Student();
			
			students[i].name = scanner.next();
			students[i].age = scanner.nextInt();
			students[i].birthday = new Date();
			
			
		}
		***/
		Teacher tt = new Teacher();
		tt.setName("frank");
		tt.setAge(37);
		tt.setBirthday(new Date());
		//tt.age = 22;
		//tt.name = "frank";
		//tt.birthday = new Date();
		
		tt.work();
		
		Student ss = new Student();
		ss.setName("liujian");
		ss.setAge(29);
		ss.setBirthday(new Date());
		
		
		ss.study();
		
		{
			String value ="aa";
			System.out.println(value);
			value = "bbb";
		}
		//System.out.println(value);
		
		
	}

}

abstract class  Person{
	private String name;
	private int age;
	private Date birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString(){
		return printPerson();
	}
	
	private String printPerson(){
		StringBuilder sb = new StringBuilder();
		aaa();
		sb.append("name =" ).append(name).append("\n") 
			.append("age =").append(age).append("\n")
			.append("birthday =").append(birthday).append("\n");
		return sb.toString();
	}
	
	private void aaa(){
		aaa();
	}
	
	
	
}



class Teacher extends Person{
	
	void work(){
	}
	
}


class Student extends Person {
	
	private String no;
	
	
	
	public String getNo() {
		return no;
	}



	public void setNo(String no) {
		this.no = no;
	}



	void study(){
		
	}
}

