package net.frank.cheer.demo.ch16;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.util.Date;

public class ConstructorTest {

	public static void main(String[] args) throws Exception {
		Constructor<?>[] constuctors =  User.class.getConstructors();
		
		for(int i=0;i<constuctors.length;i++){
			Constructor<?> constructor = constuctors[i];
			if(constructor.getParameterTypes()==null || 
					constructor.getParameterTypes().length ==0){
				System.out.println("This Constructor Method not have any parameter(s)");
				
				Object user =  constructor.newInstance();
				System.out.println(user);
			}else{
				System.out.
					println("This Constructor Method not have "+constructor.getParameterTypes().length +" parameter(s)");
				
				if(constructor.getParameterTypes().length > 1){
					Object user =  constructor.newInstance("zhangsan",new Date());
					System.out.println(user);
				}else{
					Object user =  constructor.newInstance("zhangsan");
					System.out.println(user);
				}	
			}
		}
	}
}

class User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7998596684191773558L;
	private String id;
	private String name;
	private Date birthday;
	
	public User()throws RuntimeException,Exception,ParseException {
		
	}
	
	public User(String name){
		this.name = name;
	}
	
	public User(String name, Date birthday){
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