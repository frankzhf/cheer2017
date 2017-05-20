package net.frank.cheer.demo.ch13;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EventListenerTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2752626601841779590L;

	public EventListenerTest(){
		setTitle("Event Listener Test");
		setSize(200,200);
		setLayout(new BorderLayout());
		JPanel mainPanel = new JPanel();
		add(mainPanel,BorderLayout.CENTER);
		
		mainPanel.setLayout(new GridLayout(2,2,5,5));
		JLabel userLabel = new JLabel("”√ªß√˚");
		mainPanel.add(userLabel);
		JTextField userTextField = new JTextField();
		mainPanel.add(userTextField);
		userTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				//e.
				System.out.println("UserName field trigger focusLost");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("UserName field trigger focusGained");
			}
		});
		
		
		
		JLabel passwordLabel = new JLabel("√‹¬Î");
		mainPanel.add(passwordLabel);
		JPasswordField passworkField = new JPasswordField();
		mainPanel.add(passworkField);
		
		passworkField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("Password field trigger focusLost");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("Password field trigger focusLost");
			}
		});
		
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel,BorderLayout.SOUTH);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("You click exit button");
				System.exit(0);
			}
			
		});
		buttonPanel.add(exit);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		JFrame frame = new EventListenerTest();
		frame.setVisible(true);
	}
	
}


