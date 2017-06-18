package net.frank.jee.prototype;

import java.io.IOException;
import java.io.InputStream;

public class Request {
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
	
}
