package com.cheer.ssm.service;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.ssm.dao.UserDao;
import com.cheer.ssm.dao.UserLogDao;
import com.cheer.ssm.domain.User;
import com.cheer.ssm.domain.UserLog;
import com.cheer.ssm.listener.ClientSession;

public class LoginService {
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserLogDao userLogDao;
	
	@Transactional
	public void initTestData(){
		User user = new User();
		user.setUserName("admin");
		user.setPassword("123456");
		user.setCredits(0);
		userDao.insert(user);
		log.info("Prepared data success!");
	}
	
	@Transactional
	public ClientSession login(String userName,String password,String ip){
		Date current = new Date();
		ClientSession cs = new ClientSession();
		User existUser = userDao.findForUserName(userName);
		if(existUser == null){
			cs.setLoginStatus(ClientSession.USER_NOT_EXISTS);
		}else{
			if(password.equals(existUser.getPassword())){
				cs.setLoginStatus(ClientSession.LOGINED);
				cs.setUser(existUser);
				
				existUser.setLastIp(ip);
				existUser.setLastLogin(current);
				existUser.setCredits(existUser.getCredits()+1);
				userDao.update(existUser);
				
				UserLog userLog = new UserLog();
				userLog.setUserId(existUser.getId());
				userLog.setIp(ip);
				userLog.setLastLogin(current);
				userLogDao.insert(userLog);
				
			}else{
				cs.setLoginStatus(ClientSession.INVLID_PWD);
			}
		}
		return cs;
	}
}
