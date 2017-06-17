package net.frank.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("from service");
		PrintWriter out = response.getWriter();
		
		String responseHeader = "HTTP/1.1 200 \r\n" +
				"Content-Type: text/html\r\n" +
				"Content-Length: "+39+"\r\n" +
				"\r\n";
		out.print(responseHeader);
		out.print("Hello. Roses are red.\r\n");
		out.print("Violets are blue.");
		out.flush();
	}

}
