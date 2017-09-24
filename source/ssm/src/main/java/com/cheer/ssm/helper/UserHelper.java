package com.cheer.ssm.helper;

import java.util.List;

import com.cheer.ssm.domain.User;
import com.cheer.ssm.domain.UserLog;

public class UserHelper extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6626263241531283580L;
	private List<UserLog> userLogs;

	public List<UserLog> getUserLogs() {
		return userLogs;
	}

	public void setUserLogs(List<UserLog> userLogs) {
		this.userLogs = userLogs;
	}

	@Override
	public String toString() {
		return "UserHelp [super="+super.toString()+"\n,userLogs=" + userLogs + "]";
	}
}
