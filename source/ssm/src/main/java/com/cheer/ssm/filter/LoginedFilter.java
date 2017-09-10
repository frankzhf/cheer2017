package com.cheer.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cheer.ssm.listener.ClientSession;

public class LoginedFilter implements Filter {
	private transient Log log = LogFactory.getLog(getClass());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//如果是登录，过
		//如果不是登录，检查一下session.getAttribute(ClientSession.HTTP_SESSION_KEY).loginStatus == ClientSession.LOGINED,过
		//让它登录
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		log.debug("Request URI -> " + httpRequest.getRequestURI());
		if((httpRequest.getContextPath() + "/login").equals(httpRequest.getRequestURI())){
			chain.doFilter(request, response);
		}else{
			Object client = httpRequest.getSession().getAttribute(ClientSession.HTTP_SESSION_KEY);
			if(client == null){
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
			}else{
				ClientSession cs = (ClientSession) client;
				if(ClientSession.LOGINED == cs.getLoginStatus()){
					chain.doFilter(request, response);
				}else{
					httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
				}
			}	
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
