package net.frank.cheer.demo.ch18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreadControllerTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new ThreadControllerFrame();
				frame.setVisible(true);
			}
			
		});

	}
}

class ThreadControllerFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8068891321155013122L;

	private static Color[] colors = {
			Color.RED,
			Color.BLUE,
			Color.BLACK,
			Color.CYAN,
			Color.YELLOW,
			Color.GREEN,
			Color.MAGENTA,
			Color.WHITE
		};
	
	private Thread liver;
	private JPanel main;
	private JButton startButton;
	private JButton breakButton;
	private JButton stopButton;
	
	private static int threadStatus =0;  //init  1  run   2 break
	
	public ThreadControllerFrame(){
		setTitle("Thread Control Test");
		setSize(200,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		main = new JPanel();
		add(main,BorderLayout.CENTER);
		JPanel commandPanel = new JPanel();
		add(commandPanel,BorderLayout.SOUTH);
		commandPanel.setLayout(new GridLayout(1, 3));
		
		startButton = new JButton("开始");
		breakButton = new JButton("暂停");
		stopButton = new JButton("结束");
		
		commandPanel.add(startButton);
		commandPanel.add(breakButton);
		commandPanel.add(stopButton);
		
		liver = new Thread(new Runnable(){
			int x=30;
			int y=50;
			@Override
			public void run() {
				while(threadStatus!=0){  //stop() 
					try {
						Thread.sleep(200);    
					} catch (InterruptedException e) {
						// if you call liver.interrupted();
						// this will throws InterruptedException{
						//		System.exit(0);
						// }
						e.printStackTrace();
					}
					if(threadStatus == 1){    //yeid() // wait()  // nodtify()  // notifyAll()
						Random r = new Random();
						int index = r.nextInt(colors.length-1);
						Graphics g = getGraphics();
						g.setColor(colors[index]);
						g.drawLine(x, y, 100, y++);
						if(y>80){
							y=50;
						}
					}
				}	
			}
		});
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				liver.start();
				threadStatus = 1;
				refrushButtonsStatus();
			}
		});
		
		breakButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(threadStatus  == 2){
					threadStatus = 1;
				}else{
					threadStatus  = 2;
				}
				refrushButtonsStatus();
			}
		});
		
		stopButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 *  you can call Thread.interrupted()
				 *  liver.interrupted();
				 */
				threadStatus = 0;
				refrushButtonsStatus();
				System.exit(0);
			}
		});
		refrushButtonsStatus();
	}
	
	private void refrushButtonsStatus(){
		if(threadStatus == 0){
			startButton.setEnabled(true);
			breakButton.setEnabled(false);
			stopButton.setEnabled(false);
		}else if(threadStatus == 1){
			startButton.setEnabled(false);
			breakButton.setText("暂停");
			breakButton.setEnabled(true);
			stopButton.setEnabled(true);
		}else{
			startButton.setEnabled(false);
			breakButton.setText("继续");
			breakButton.setEnabled(true);
			stopButton.setEnabled(true);
		}
	}
	
}