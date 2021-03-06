package net.frank.jee.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class Request implements ServletRequest {
	private InputStream input;
	private String uri;
	private static final int DEFAULT_BUFFER_LENGTH=2048;
	
	public Request(InputStream input){
		this.input = input;
	}
	
	public String getUri(){
		return this.uri;
	}
	
	public void parse(){
		
		StringBuffer sb = new StringBuffer(DEFAULT_BUFFER_LENGTH);
		int i;
		byte[] buffer = new byte[DEFAULT_BUFFER_LENGTH];
		try{
			i= input.read(buffer);
		}catch(IOException e){
			e.printStackTrace();
			i = -1;
		}
		for(int j=0;j<i;j++){
			sb.append((char)buffer[j]);
		}
		System.out.println(sb.toString());
		uri = parseUri(sb.toString());
	}
	
	private String parseUri(String requestString){
		int index0,index1;
		index0 = requestString.indexOf(' ');
		if(index0!=-1){
			index1 = requestString.indexOf(' ',index0+1);
			if(index1 > index0){
				return requestString.substring(index0+1,index1);
			}
		}
		return null;
	}

	@Override
	public Object getAttribute(String arg0) {
		return null;
	}

	@Override
	public Enumeration<?> getAttributeNames() {
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public int getContentLength() {
		return 0;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public String getLocalAddr() {
		return null;
	}

	@Override
	public String getLocalName() {
		return null;
	}

	@Override
	public int getLocalPort() {
		return 0;
	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return null;
	}

	@Override
	public String getParameter(String arg0) {
		return null;
	}

	@Override
	public Map<String,Object> getParameterMap() {
		return null;
	}

	@Override
	public Enumeration<Object> getParameterNames() {
		return null;
	}

	@Override
	public String[] getParameterValues(String arg0) {
		return null;
	}

	@Override
	public String getProtocol() {
		return null;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return null;
	}

	@Override
	public String getRealPath(String arg0) {
		return null;
	}

	@Override
	public String getRemoteAddr() {
		return null;
	}

	@Override
	public String getRemoteHost() {
		return null;
	}

	@Override
	public int getRemotePort() {
		return 0;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		return null;
	}

	@Override
	public String getScheme() {
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public int getServerPort() {
		return 0;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public void removeAttribute(String arg0) {
		
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		
	}

	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		
	}
	
}
