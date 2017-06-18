package net.frank.tiger.executor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class SendScreenImg extends Thread {
	
	private transient Logger log = Logger.getLogger(SendScreenImg.class);
	
	private BufferedImage mouseIcon = null;
	
	//private int serverPort = 8002;
	
	private ServerSocket serverSocket;
	
	private Robot robot;
	
	public Dimension screen;
	
	public Rectangle rect;
	
	private Socket socket;
	
	public SendScreenImg (String port){
		try{
			int _port = Integer.parseInt(port);
			serverSocket = new ServerSocket(_port);
			serverSocket.setSoTimeout(864000000);
			robot = new Robot();
			mouseIcon = ImageIO.read(Thread.currentThread().
					getContextClassLoader().getResourceAsStream("mouse.jpg"));
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		rect = new Rectangle(screen);
	}
	
	@Override
	public void run(){
		while(true){
			try{
				socket = serverSocket.accept();
				ZipOutputStream zip = new ZipOutputStream(
						new DataOutputStream(socket.getOutputStream()));
				zip.setLevel(9);
				try{
					BufferedImage img = robot.createScreenCapture(rect);
					Point point = MouseInfo.getPointerInfo().getLocation();
					Graphics graphics = img.createGraphics();
					graphics.drawImage(mouseIcon,
							point.x,point.y
							,10,10,null);
					zip.putNextEntry(new ZipEntry("screen.jpg"));
					ImageIO.write(img, "jpg", zip);
					if(zip!=null){
						zip.close();
					}
				}catch(IOException e){
					log.error(e.getMessage(),e);
				}
			}catch(IOException ioe){
				log.error(ioe.getMessage(),ioe);
			}finally{
				if(socket!=null){
					try{
						socket.close();
					}catch(IOException e){}
				}
			}
		}
	}
}
