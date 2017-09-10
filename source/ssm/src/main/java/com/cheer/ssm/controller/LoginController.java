package com.cheer.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheer.ssm.dao.UserDao;
import com.cheer.ssm.listener.ClientSession;
import com.cheer.ssm.service.LoginService;

@Controller
@RequestMapping
public class LoginController {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			HttpServletRequest request){
		log.debug("Param [userName] -> " + userName);
		log.debug("Param [password] -> " + password);
		
		String ip = request.getRemoteAddr();
		ClientSession client = loginService.login(userName, password,ip);
		
		if(ClientSession.LOGINED == client.getLoginStatus()){
			request.getSession().setAttribute(ClientSession.HTTP_SESSION_KEY, client);
		}else{
			if(ClientSession.USER_NOT_EXISTS == client.getLoginStatus()){
				request.setAttribute("errorMsg", "帐户不存在！");
				
			}else if(ClientSession.INVLID_PWD == client.getLoginStatus()){
				request.setAttribute("errorMsg", "密码与帐号不对！");
			}
			return "login";
		}
		return "home";
	}
	
	
	
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(){
		
		return "home";
	}
	
	@RequestMapping(value="/ping",method=RequestMethod.POST)
	public String ping(){
		
		return "ping";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(HttpSession session){
		session.removeAttribute(ClientSession.HTTP_SESSION_KEY);
		return "login";
	}
	
	
	
}