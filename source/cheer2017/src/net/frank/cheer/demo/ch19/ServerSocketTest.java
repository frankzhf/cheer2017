package net.frank.cheer.demo.ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8081);
		System.out.println("Server startup");
		Socket socket = serverSocket.accept(); 
		System.out.println("Client connected!");
		/***
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		}).start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		}).start();
		***/
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		while(run){
			String income = in.readLine();
			System.out.println("Cleint sent me : " + income);
			System.out.print("Enter reply: ");
			String outgo = scanner.nextLine();
			if("bye".equals(outgo)){
				run = false;
				out.println(outgo);
			}else{
				out.println(outgo);
			}
		}
		scanner.close();
		socket.close();
		serverSocket.close();
	}

}
