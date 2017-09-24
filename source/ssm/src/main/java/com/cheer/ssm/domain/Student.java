package com.cheer.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6827567378846797998L;
	private Long id;
	private String name;
	private String stuNo;
	private byte sex;
	private Date birthday;
	private byte status;
	private Date createDt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", stuNo=" + stuNo + ", sex=" + sex + ", birthday=" + birthday
				+ ", status=" + status + ", createDt=" + createDt + "]";
	}
	
}
