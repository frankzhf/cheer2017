package net.frank.cheer.demo.ch13;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrameTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4912935871528242629L;

	public CalculatorFrameTest(){
		setTitle("Calculator");
		setSize(400,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JTextField showField = new JTextField("0");
		showField.setHorizontalAlignment(JTextField.RIGHT);
		
		showField.setText("1000");
		
		System.out.println(showField.getText());
		
		add(showField,BorderLayout.CENTER);
		
		JPanel center = new JPanel();
		
		add(center,BorderLayout.SOUTH);
		center.setLayout(new GridLayout(6,6,1,1));
		
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
			center.add(button);
			if("".equals(buttonLabel[i])){
				button.setEnabled(false);
			}else{
				button.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton _me = (JButton)e.getSource();
						System.out.println(_me.getText());
					}
					
				});
			}
			
			
			
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new CalculatorFrameTest();
		frame.setVisible(true);

	}

}
