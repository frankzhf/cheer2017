package net.frank.cheer.demo.ch13;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrameTest extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4912935871528242629L;
	
	private static boolean ONE_VALUE_FLAG = false;
	
	private static final BigDecimal HUB = new BigDecimal(100);
	
	private String oneValue;
	private String operate;
	private String twoValue;
	
	public CalculatorFrameTest(){
		setTitle("Calculator");
		setSize(400,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		final JTextField showField = new JTextField("0");
		showField.setHorizontalAlignment(JTextField.RIGHT);
		
		showField.setText("0");
		
		System.out.println(showField.getText());
		
		add(showField,BorderLayout.CENTER);
		
		JPanel center = new JPanel();
		
		add(center,BorderLayout.SOUTH);
		center.setLayout(new GridLayout(5,4,1,1));
		
		String [] buttonLabel = new String[]{
				"C","+/-","%","/",
				"7","8","9","*",
				"4","5","6","-",
				"1","2","3","+",
				"0","",".","="
				
		};
		
		for(int i=0;i<20;i++){
			JButton button = new JButton(buttonLabel[i]);
			center.add(button);
			if("".equals(buttonLabel[i])){
				button.setEnabled(false);
			}else{
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton _me = (JButton)e.getSource();
						if("C".equals(_me.getText())){
							showField.setText("0");
							ONE_VALUE_FLAG = false;
						}else if("0".equals(_me.getText())
								||"1".equals(_me.getText())
								||"2".equals(_me.getText())
								||"3".equals(_me.getText())
								||"4".equals(_me.getText())
								||"5".equals(_me.getText())
								||"6".equals(_me.getText())
								||"7".equals(_me.getText())
								||"8".equals(_me.getText())
								||"9".equals(_me.getText())
								){
							if("0".equals(showField.getText())){
								showField.setText(_me.getText());
							}else{
								showField.setText(showField.getText() +_me.getText());
							}
						}else if(".".equals(_me.getText())){
							if(!showField.getText().contains(".")){
								showField.setText(showField.getText() +_me.getText());
							}
						}else if("+/-".equals(_me.getText())){
							if(showField.getText().startsWith("-")){
								showField.setText(showField.getText().substring(1));
							}else{
								showField.setText("-"+showField.getText());
							}
						}else if("%".equals(_me.getText())){
							BigDecimal value = new BigDecimal(showField.getText()).divide(HUB);
							showField.setText(value.toString());
						}else if("+".equals(_me.getText())
								||"-".equals(_me.getText())
								||"*".equals(_me.getText())
								||"/".equals(_me.getText())){
							if(!ONE_VALUE_FLAG){
								oneValue = showField.getText();
								operate = _me.getText();
								showField.setText("0");
								ONE_VALUE_FLAG = true;
							}else{
								twoValue = showField.getText();
								BigDecimal one = new BigDecimal(oneValue);
								BigDecimal two = new BigDecimal(twoValue);
								if("+".equals(operate)){
									showField.setText(one.add(two).toString());
								}else if("-".equals(operate)){
									showField.setText(one.subtract(two).toString());
								}else if("*".equals(operate)){
									showField.setText(one.multiply(two).toString());
								}else{
									showField.setText(one.divide(two,16,BigDecimal.ROUND_HALF_UP).toString());
								}
								oneValue = null;
								twoValue = null;
								ONE_VALUE_FLAG = false;
							}
						}else if("=".equals(_me.getText())){
							if(ONE_VALUE_FLAG){
								twoValue = showField.getText();
								BigDecimal one = new BigDecimal(oneValue);
								BigDecimal two = new BigDecimal(twoValue);
								if("+".equals(operate)){
									showField.setText(one.add(two).toString());
								}else if("-".equals(operate)){
									showField.setText(one.subtract(two).toString());
								}else if("*".equals(operate)){
									showField.setText(one.multiply(two).toString());
								}else{
									showField.setText(one.divide(two,16,BigDecimal.ROUND_HALF_UP).toString());
								}
								oneValue = null;
								twoValue = null;
								ONE_VALUE_FLAG = false;
							}
							
						}
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
