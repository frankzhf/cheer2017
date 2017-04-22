package net.frank.cheer.demo.ch07;

import javax.swing.JFrame;

public class DemoFrame extends JFrame {
	private static final long serialVersionUID = -3546828821114521125L;

	public DemoFrame(){
		this.setTitle("Hello My JFrame");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}