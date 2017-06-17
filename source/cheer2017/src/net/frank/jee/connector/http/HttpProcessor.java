package net.frank.jee.connector.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpProcessor {

	private HttpConnector connector = null;
	private HttpRequest request;

	public HttpProcessor(HttpConnector connector) {

	}

	public void process(Socket socket){
		SocketInputStream input = null;
		OutputStream output = null;
		try{
			input = new SocketInputStream(socket.getInputStream(), 2048);
			output = socket.getOutputStream();
		
		}catch(IOException e){
			
		}
	}

}
