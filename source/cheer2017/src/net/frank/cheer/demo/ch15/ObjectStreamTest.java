package net.frank.cheer.demo.ch15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ObjectStreamTest {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args)throws Exception{
		Person p = new Person();
		p.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		p.setName("zhangsan");
		p.setBirthday(df.parse("1987-10-10"));
		
		/*** File.separatorChar  **/
		ObjectOutputStream out = null;
		FileOutputStream outFile = null;
		try{
			outFile = new FileOutputStream("E:"+File.separatorChar+"zhaofeng/test/object.bin");
			out = new ObjectOutputStream(outFile);
			out.writeObject(p);
			out.flush();
		}finally{
			if(outFile!=null){
				outFile.close();
			}
			if(out!= null){
				out.close();
			}
		}
	}
}

class Person implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7998596684191773558L;
	private String id;
	private String name;
	private Date birthday;
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
	
}