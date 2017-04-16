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
		//tt.age = 22;
		//tt.name = "frank";
		//tt.birthday = new Date();
		
		tt.work();
		
		Student ss = new Student();
		//ss.age = 11;
		//ss.name = "wuyang";
		//ss.birthday = new Date();
		ss.study();
		
	}

}

abstract class  Person{
	private String name;
	private int age;
	private Date birthday;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	
	
}



class Teacher extends Person{
	
	void work(){
		
	}
	
}


class Student extends Person {
	
	String no;
	void study(){
		
	}
}

