package net.frank.cheer.exercise.ch90.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
	
	public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5074990880349853410L;
	private String id;
	private String name;
	private String sex;
	private Date birthday;
	private String height;
	private String weight;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(getId()).append("\t").
			append(getName()).append("\t").
			append(getSex()).append("\t").
			append(df.format(getBirthday())).append("\t").
			append(getHeight()).append("\t").
			append(getWeight());
		return sb.toString();
	}
	
	
}
