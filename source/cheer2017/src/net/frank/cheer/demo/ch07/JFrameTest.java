package net.frank.cheer.demo.ch07;

import java.awt.EventQueue;

public class JFrameTest {
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				new DemoFrame(); 
			}
		});
		
		
		
		
	}
}