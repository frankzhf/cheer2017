package com.cheer.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1903676874531712240L;
	private Long id;
	private String userName;
	private int credits;
	private String password;
	private Date lastLogin;
	private String lastIp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", credits=" + credits + ", password=" + password
				+ ", lastLogin=" + lastLogin + ", lastIp=" + lastIp + "]";
	}
	
}
