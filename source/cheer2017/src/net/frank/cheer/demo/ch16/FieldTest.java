package net.frank.cheer.demo.ch16;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.util.Date;

public class FieldTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Operator ope = new Operator();
		System.out.println(ope);
		Field field = Operator.class.getDeclaredField("name");
		
		System.out.println("Name is "  + Modifier.toString(field.getModifiers()));
		field.setAccessible(true);
		field.set(ope, "lisi");
		field.setAccessible(false);
		
		System.out.println(ope);
	}

}


class Operator implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7998596684191773558L;
	
	
	private String id;
	private String name;
	private Date birthday;
	
	
	public Operator()throws RuntimeException,Exception,ParseException {
		
	}
	
	public Operator(String name){
		this.name = name;
	}
	
	public Operator(String name, Date birthday){
		this.name = name;
		this.birthday = birthday;
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
	
	
	@Override
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