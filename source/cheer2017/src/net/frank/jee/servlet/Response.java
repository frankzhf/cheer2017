package net.frank.jee.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response implements ServletResponse {
	
	private static final int BUFFER_SIZE = 1024;
	
	private Request request;
	
	private OutputStream output;
	
	private PrintWriter writer;
	
	public Response(OutputStream output){
		this.output = output;
	}
	
	public void setRequest(Request request){
		this.request = request;
	}
	
	public void sendStaticResource() throws IOException{
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try{
			File file = new File(HttpServer.WEB_ROOT,request.getUri());
			if(file.exists()){
				
				
				String responseHeader = "HTTP/1.1 200 \r\n" +
						"Content-Type: text/html\r\n" +
						"Content-Length: "+file.length()+"\r\n" +
						"\r\n";
				output.write(responseHeader.getBytes());
				fis = new FileInputStream(file);
				int ch = fis.read(bytes,0,BUFFER_SIZE);
				while(ch!=-1){
					output.write(bytes,0,ch);
					ch = fis.read(bytes,0,BUFFER_SIZE);
				}
			}else{
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
					"Content-Type: text/html\r\n" +
					"Content-Length: 23\r\n" +
					"\r\n" +
					"<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		}catch(Exception e){
			e.printStackTrace();
			
		} finally {
			if(fis!=null){
				fis.close();
			}
		}
		
	}

	@Override
	public void flushBuffer() throws IOException {
		
	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		writer = new PrintWriter(output,true);
		return writer;
	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void resetBuffer() {
		
	}

	@Override
	public void setBufferSize(int arg0) {
		
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		
	}

	@Override
	public void setContentLength(int arg0) {
		
	}

	@Override
	public void setContentType(String arg0) {
		
	}

	@Override
	public void setLocale(Locale arg0) {
		
	}
	
}
