package net.frank.cheer.demo.ch13;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class BaseComponentTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4143165138445870847L;

	public BaseComponentTest(){
		setTitle("Component Test");
		setSize(600,600);
		
		setLayout(new GridLayout(10,1,5,5));
		
		JPanel radioGroupPanel = new JPanel();
		add(radioGroupPanel);
		
		radioGroupPanel.setLayout(new FlowLayout());
		ButtonGroup sexButtonGroup = new ButtonGroup();
		
		JRadioButton manRadio = new JRadioButton("男");
		JRadioButton womanRadio = new JRadioButton("女",true);
		
		sexButtonGroup.add(manRadio);
		sexButtonGroup.add(womanRadio);
		
		radioGroupPanel.add(manRadio);
		radioGroupPanel.add(womanRadio);
		
		
		JRadioButton hanRadio = new JRadioButton("汉",true);
		JRadioButton noHanRadio = new JRadioButton("非汉");
		ButtonGroup nationButtonGroup = new ButtonGroup();
		nationButtonGroup.add(hanRadio);
		nationButtonGroup.add(noHanRadio);
		
		radioGroupPanel.add(hanRadio);
		radioGroupPanel.add(noHanRadio);
		
			
		JPanel checkoxBGroupPanel = new JPanel();
		add(checkoxBGroupPanel);
		checkoxBGroupPanel.setLayout(new FlowLayout());
		//ButtonGroup favButtonGroup = new ButtonGroup();
		
		JCheckBox sportCheckBox = new JCheckBox("运动");
		JCheckBox bookCheckBox = new JCheckBox("阅读");
		
		//favButtonGroup.add(sportCheckBox);
		//favButtonGroup.add(bookCheckBox);
		
		checkoxBGroupPanel.add(sportCheckBox);
		checkoxBGroupPanel.add(bookCheckBox);
		
		
		
		JPanel downListPanel = new JPanel();
		add(downListPanel);
		downListPanel.setLayout(new FlowLayout());
		
		JComboBox dropdown = new JComboBox(new Object[]{"1","2","3"});
		downListPanel.add(dropdown);
		
		JPanel listPanel = new JPanel();
		add(listPanel);
		listPanel.setLayout(new FlowLayout());
		listPanel.add(new JList(new Object[]{"1","2","3"}));
		
		JPanel passwordPanel = new JPanel();
		add(passwordPanel);
		passwordPanel.setLayout(null);
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(10, 10,100,30);
		passwordField.setEchoChar('#');
		passwordPanel.add(passwordField);
		
		JPanel textAreaPanel = new JPanel();
		add(textAreaPanel);
		textAreaPanel.setLayout(new FlowLayout());
		textAreaPanel.add(new JTextArea(2,25));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args){
		JFrame frame = new BaseComponentTest();
		frame.setVisible(true);
	}
}
