package net.frank.cheer.demo.ch15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TransientTest {
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String [] args)throws Exception{
		Admin u = new Admin();
		u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		u.setName("zhangsan");
		u.setBirthday(df.parse("1987-10-10"));
		u.setPassword("123456");
		System.out.println("Varrible [u] -> " + u);
		/*** File.separatorChar  **/
		ObjectOutputStream out = null;
		FileOutputStream outFile = null;
		try{
			outFile = new FileOutputStream("E:"+File.separatorChar+"zhaofeng/test/object3.bin");
			out = new ObjectOutputStream(outFile);
			out.writeObject(u);
			out.flush();
		}finally{
			if(outFile!=null){
				outFile.close();
			}
			if(out!= null){
				out.close();
			}
		}
		ObjectInputStream in = null;
		FileInputStream inFile = null;
		try{
			inFile = new FileInputStream("E:"+File.separatorChar+"zhaofeng/test/object3.bin");
			in = new ObjectInputStream(inFile);
			Object _u = in.readObject();
			if(_u instanceof Admin){
				Admin __u = (Admin) _u;
				System.out.println("Varrible [__u] -> " + __u);
			}
		}finally{
			if(inFile!=null){
				inFile.close();
			}
			if(in!= null){
				in.close();
			}
		}
	}
}


class Admin implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5545293899112788364L;
	private String id;
	private String name;
	private Date birthday;
	private transient String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", birthday=" + birthday + ", password=" + password + "]";
	}
}