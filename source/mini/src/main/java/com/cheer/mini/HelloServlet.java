package com.cheer.mini;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9147752815449638001L;
	
	private transient Log log = LogFactory.getLog(getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("Trigger doGet method.");
		String abc = req.getParameter("abc");
		log.debug("Varible [abc] -> " + abc);
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Hello Servlet</title></head><body><h1>Hello Servlet!</h1></body></html>");
		out.flush();
		//super.doGet(req, resp);
	}

	@Override
	public void destroy() {
		log.debug("Trigger destroy method.");
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		log.debug("Trigger init method.");
		super.init(config);
	}
	
}
