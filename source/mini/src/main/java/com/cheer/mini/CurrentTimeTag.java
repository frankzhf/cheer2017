package com.cheer.mini;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CurrentTimeTag extends SimpleTagSupport {
	
	private String format;
	
	public void setFormat(String format) {
		this.format = format;
	}

	public void doTag() throws JspException,IOException{
		Date current = new Date();
		DateFormat df = new SimpleDateFormat(format);
		getJspContext().getOut().print("<h1>"+df.format(current)+"<h1>");
	}
}
