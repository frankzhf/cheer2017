package net.frank.cheer.demo.ch13;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9055579075470188353L;

	public FlowLayoutTest(){
		setSize(400,300);
		setTitle("My Flow Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		for(int i=0;i<20;i++){
			JLabel label = new JLabel("Welcome, Swing!");
			add(label);
		}
		setVisible(true);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}

}
