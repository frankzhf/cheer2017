package net.frank.cheer.demo.ch16;

import java.util.Date;

public class ClazzTest {
	public static void main(String[] args){
		Package _package =
				ClazzTest.class.getPackage();
		System.out.println(_package.getName());
		
		Class<?> clazz = ClazzTest.class;
		System.out.println(clazz.getName());
		
		System.out.println(clazz.getSuperclass().getName());
		Class<?> personClass = Person.class;
		Class<?>[] inferfaces = personClass.getInterfaces();
		System.out.println(inferfaces[0].getName());
		System.out.println(inferfaces[1].getName());
		
	}
}
class Person implements java.io.Serializable, java.lang.Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7998596684191773558L;
	private String id;
	private String name;
	private Date birthday;
	
	public Person(){
		
	}
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(getClass().getName()).append("[\n")
			.append("id=").append(getId()).append("\n")
			.append("name=").append(getName()).append("\n")
			.append("birthday=").append(getBirthday()).append("\n")
			.append("]");
		return sb.toString();
	}
	
}