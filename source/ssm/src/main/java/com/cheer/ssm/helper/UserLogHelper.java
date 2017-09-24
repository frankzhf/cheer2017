package com.cheer.ssm.helper;

import com.cheer.ssm.domain.User;
import com.cheer.ssm.domain.UserLog;

public class UserLogHelper extends UserLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 348795225599362075L;
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserLogHelper [super = "+super.toString()+" user=" + user + "]";
	}
}
