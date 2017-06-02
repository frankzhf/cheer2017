package net.frank.cheer.exercise.ch90.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5074990880349853410L;
	private String id;
	private String name;
	private String sex;
	private Date birthday;
	private short leight;
	private short weight;
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
	public short getLeight() {
		return leight;
	}
	public void setLeight(short leight) {
		this.leight = leight;
	}
	public short getWeight() {
		return weight;
	}
	public void setWeight(short weight) {
		this.weight = weight;
	}
	
	
	
	
}
