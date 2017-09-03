package com.cheer.mini.ajax;

import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AjaxServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3474117125711010635L;
	protected transient Log log = LogFactory.getLog(getClass());
	
	
}
