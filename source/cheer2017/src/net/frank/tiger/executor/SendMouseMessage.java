package net.frank.tiger.executor;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SendMouseMessage extends Thread {
	private int port = 8001;
	private ServerSocket server;
	private Socket socket;
	private String operateStr;
	
	public SendMouseMessage(){
		try{
			server = new ServerSocket(port);
		}catch(IOException e){
			
		}
	}
	
	public void run(){
		while(true){
			Point point = MouseInfo.getPointerInfo().getLocation();
			operateStr = "Movemouse," + point.x +"," + point.y;
			try{
				socket= server.accept();
				socket.setSoTimeout(1000000);
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				output.write(operateStr.getBytes());
				output.flush();
				output.close();
			}catch(IOException e){
				break;
			}
		}
	}
}
