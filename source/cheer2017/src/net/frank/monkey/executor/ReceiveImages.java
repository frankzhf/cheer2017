package net.frank.monkey.executor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

public class ReceiveImages extends Thread implements ImageObserver {
	private transient Logger log = Logger.getLogger(ReceiveImages.class);
	private BorderInit frame;
	private Socket socket;
	private String ip;
	private String port;

	public ReceiveImages(String ip, String port) {
		this.frame = new BorderInit(ip);
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		while (frame.getFlag()) {
			log.debug("Connected" + (System.currentTimeMillis() / 1000L % 24L % 60L) + "second(s)");
			try {
				socket = new Socket(ip, Integer.parseInt(port));
				DataInputStream ImgInput = new DataInputStream(socket.getInputStream());
				ZipInputStream imgZip = new ZipInputStream(ImgInput);
				BufferedImage img = null;
				try {
					imgZip.getNextEntry();
					img = ImageIO.read(imgZip);
					int _width = frame.jlbImg.getWidth();
					int _height = frame.jlbImg.getHeight();
					log.info("width :" + _width);
					log.info("height :" + _height);
					int screenWidth = img.getWidth(this);
					int screenHeight = img.getHeight(this);
					log.info("screenWidth :" + screenWidth);
					log.info("screenHeight :" + screenHeight);
					BufferedImage newImage = new BufferedImage(_width,_height,img.getType());
					Graphics g = newImage.getGraphics();
			        g.drawImage(img, 0,0,_width,_height,null);
			        g.dispose();					
					frame.jlbImg.setIcon(new ImageIcon(newImage));
					frame.validate();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
				try {
					imgZip.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
				try {
					TimeUnit.MILLISECONDS.sleep(100L);
				} catch (InterruptedException ie) {
					log.error(ie.getMessage(), ie);
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			} finally {
				try {
					socket.close();
				} catch (IOException localIOException2) {
				}
			}
		}
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}
}