package com.cheer.ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class UserLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7750956694109238537L;
	private Long id;
	private Long userId;
	private String ip;
	private Date lastLogin;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString() {
		return "UserLog [id=" + id + ", userId=" + userId + ", ip=" + ip + ", lastLogin=" + lastLogin + "]";
	}
	
}
