package com.cheer.ssm.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cheer.ssm.domain.User;

public class ClientSession implements HttpSessionBindingListener {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	public static final String HTTP_SESSION_KEY = "client_session";
	
	public static final byte INIT = 0;
	public static final byte LOGINED = 1;
	public static final byte USER_NOT_EXISTS = 2;
	public static final byte INVLID_PWD = 3;
	public static final byte UNKNOWN = 127;
	
	private byte loginStatus = INIT;
	
	private User user;
	
	public byte getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(byte loginStatus) {
		this.loginStatus = loginStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		log.debug("valueBound triggered!");
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		if(session!=null){
			session.invalidate();
		}
	}


	@Override
	public String toString() {
		return "ClientSession [loginStatus=" + loginStatus + ", user=" + user + "]";
	}
}
