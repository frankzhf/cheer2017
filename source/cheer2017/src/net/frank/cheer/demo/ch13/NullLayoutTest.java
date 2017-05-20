package net.frank.cheer.demo.ch13;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullLayoutTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3061616484083521179L;

	public NullLayoutTest(){
		setSize(400,300);
		setTitle("My Base Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JLabel welcome = new JLabel("Welcome");
		welcome.setBounds(100,100,70,30);
		JLabel swing = new JLabel("Swing");
		swing.setBounds(200, 70, 80, 40);
		add(welcome);
		add(swing);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new NullLayoutTest();
	}
	
	
	
	
	
	
	
	
}
