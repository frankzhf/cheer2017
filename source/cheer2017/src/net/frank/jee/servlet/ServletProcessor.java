package net.frank.jee.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;

import org.apache.tomcat.util.PropertiesUtil;

public class ServletProcessor {
	
	private static final String CLASS_ROOT = PropertiesUtil.getProperties("jee").getProperty("class.root");
	
	private static final String PACKAGE = "net.frank.jee.servlet.";
	
	public void process(Request request,Response response){
		String uri = request.getUri();
		String servletName = PACKAGE + uri.substring(uri.lastIndexOf("/")+1);
		URLClassLoader loader = null;
		try{
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File(CLASS_ROOT);
			String repository = new URL("file",null,classPath.getCanonicalPath() + File.separator).toString();
			urls[0] = new URL(null,repository,streamHandler);
			loader = new URLClassLoader(urls);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		
		Class<?> myClass = null;
		try{
			myClass = loader.loadClass(servletName);
		}catch(ClassNotFoundException e){
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		try{
			servlet = (Servlet)myClass.newInstance();
			servlet.service( request,  response);
		}catch(Exception e){
			System.out.println();
		}catch(Throwable e){
			System.out.println(e);
		}
	}
}