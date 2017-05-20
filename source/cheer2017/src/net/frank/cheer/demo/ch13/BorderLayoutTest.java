package net.frank.cheer.demo.ch13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2846222872210301365L;

	public BorderLayoutTest(){
		setTitle("Border Layout Test");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		JButton center = new JButton("Center Area");
		add(center,BorderLayout.CENTER);
		
		//JButton east = new JButton("East Area");
		//add(east,BorderLayout.EAST);
		
		JButton north = new JButton("North Area");
		add(north,BorderLayout.NORTH);
		
		JButton south = new JButton("South Area");
		add(south,BorderLayout.SOUTH);
		
		JButton west = new JButton("West Area");
		add(west,BorderLayout.WEST);
		
		
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new BorderLayoutTest();
	}
	
}
