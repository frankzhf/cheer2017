package net.frank.cheer.demo.ch17;

public class EmunTest {
	public static void main(String[] args){
		//1)
		Admin admin = new Admin();
		admin.setName("zhangsan");
		//admin.setSex("男"); //admin.setSex("nan")
		if("男".equals(admin.getSex()) ||
				"nan".equals(admin.getSex()) ||
				"male".equals(admin.getSex())){
			//
		}
		
		//2)
		//admin.setSex(Admin.SEX_NAN); //admin.setSex(Admin.SEX_NV);
		//admin.setSex("abc");admin.setSex("def")
		
		if(Admin.SEX_NAN.equals(admin.getSex())){
			//
		}
		
		
		//3)
		admin.setSex(enum_sex.M);
		if(enum_sex.M.equals(admin.getSex())){
			
		}
		
		
	}
}

class Admin{
	
	public static final String SEX_NAN = "M";
	public static final String SEX_NV = "F";
	
	private String id;
	private String name;
	//private String sex;           //nan, nv, 男，女， man, woman 
	
	private enum_sex sex; 
	
	
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
	public enum_sex getSex() {
		return sex;
	}
	public void setSex(enum_sex sex) {
		this.sex = sex;
	}
}

enum enum_sex{M,F};