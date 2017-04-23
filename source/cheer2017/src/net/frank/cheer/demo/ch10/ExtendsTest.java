package net.frank.cheer.demo.ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtendsTest {

	public static void main(String[] args) throws Exception {
		/*** base
		Person p = new Person();
		System.out.println(p);
		p.id = "p00001";
		
		Teacher t = new Teacher();
		t.id = "t00001";
		System.out.println(t);
		**/
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		/*** Visit Control property|method ***/
		
		Person p = new Person();
		p.setId("p00001");
		p.setName("pName00001");
		p.setBirthday(df.parse("1990-12-24"));
		
		System.out.println(p);
		
		
		Teacher t = new Teacher();
		t.setId("t00001");
		t.setName("tName0001");
		t.setBirthday(df.parse("1985-01-01"));
		t.setWorkYears(10);
		System.out.println(t);
		/***
		 * this, super
		 */
		
		
	}

}


/*** base
class Person{
	public String id;
	private String name;
	private Date birthday;
	
	public Person(){
		System.out.println("new Person called");
		this.name = "pName01";
		this.birthday = new Date();
	}
	
}

class Teacher extends Person{
	public Teacher(){
		System.out.println("new Teacher called");
		this.id = "320105xxxxxxxx819";
		
	}
}

***/

/** Visit Control property|method
class Person{
	private String id;
	private String name;
	private Date birthday;
	
	public Person(){
		System.out.println("new Person() called");
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Date getBirthday(){
		return this.birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append( "Person[id =").append(id).
			append(",name =").append(name).
			append(",birthday =").append(birthday);
		return sb.toString();
	}
}

class Teacher extends Person{
	public Teacher(){
		System.out.println("new Teacher() called");
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append( "Teacher[id =").append(getId()).
			append(",name =").append(getName()).
			append(",birthday =").append(getBirthday());
		return sb.toString();	
	}	
}
***/


class Person{
	private String id;
	private String name;
	private Date birthday;
	
	public Person(){
		System.out.println("new Person() called");
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Date getBirthday(){
		return this.birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	/***
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(getClass().getName()).append("[id =").append(id).
			append(",name =").append(name).
			append(",birthday =").append(birthday).
			append("]");
		return sb.toString();
	}
	***/
}

class Teacher extends Person{
	
	private int workYears;
	
	public int getWorkYears(){
		return this.workYears;
	}
	
	public void setWorkYears(int workYears){
		this.workYears = workYears;
	}
	
	
	public Teacher(){
		System.out.println("new Teacher() called");
	}
	
	/***
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(super.toString()).
		append("extention [workYears = ").append(workYears).append("]");
		return sb.toString();
	}
	***/
}