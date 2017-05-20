package net.frank.cheer.demo.ch13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8410191242002395683L;

	public GridLayoutTest(){
		setTitle("Grid Layout Test");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(6,6,1,1));
		
		String [] buttonLabel = new String[]{
				"Lsh","Rsh","Or","Xar","Not","And",
				"|","Mod","CE","C","<-","/",
				"A","B","7","8","9","*",
				"C","D","4","5","6","-",
				"E","F","1","2","3","+",
				"(",")","+-","0","","=",
				
		};
		
		for(int i=0;i<36;i++){
			JButton button = new JButton(buttonLabel[i]);
			add(button);
		}
		
		
		
	}
	
	
	
	public static void main(String[] args){
		JFrame f =  new GridLayoutTest();
		f.setVisible(true);
	}
	
	
}
