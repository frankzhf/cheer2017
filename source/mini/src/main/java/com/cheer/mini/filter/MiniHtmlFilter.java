package com.cheer.mini.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MiniHtmlFilter implements Filter {
	
	private transient Log log = LogFactory.getLog(getClass());
	
	private String encode;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("MiniHtmlFilter.init()");
		encode = filterConfig.getInitParameter("encode");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("MiniHtmlFilter.doFilter");
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
