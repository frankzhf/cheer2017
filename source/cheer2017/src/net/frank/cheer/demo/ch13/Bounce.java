package net.frank.cheer.demo.ch13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bounce {
	public static void main(String[] args){
		JFrame frame = new BounceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class BounceFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3391408462904768447L;
	//private static final int DELAY = 20;
	private static final int STEPS = 1000;
	
	private BallComponent comp;
	
	public BounceFrame(){
		setTitle("Bounce");
		comp = new BallComponent();
		add(comp,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel,"Start",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});
		addButton(buttonPanel,"Close",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(buttonPanel,BorderLayout.SOUTH);
		pack();
	}
	
	public void addButton(Container c,String title,ActionListener listener){
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall(){
		final Ball ball = new Ball();
		comp.add(ball);
		for(int i =1;i<= STEPS;i++){
			ball.move(comp.getBounds());
			comp.paint(comp.getGraphics());
		}	
	}
}

class Ball{
	private static final int X_SIZE = 15;
	private static final int Y_SIZE = 15;
	
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	public void move(Rectangle2D bounds){
		x += dx;
		y += dy;
		if(x < bounds.getMinX()){
			x = bounds.getMinX();
			dx = -dx;
		}
		if(x + X_SIZE >= bounds.getMaxX()){
			x = bounds.getMaxX() - X_SIZE;
			dx = -dx;
		}
		if(y< bounds.getMinY()){
			y = bounds.getMinY();
			dy = -dy;
		}
		if(y+ Y_SIZE >= bounds.getMaxY()){
			y = bounds.getMaxY() - Y_SIZE;
			dy = -dy;
		}
		
	}
	
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,X_SIZE,Y_SIZE);
	}
}

class BallComponent extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7373446862590086313L;
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	private List<Ball> balls = new ArrayList<Ball>();
	public void add(Ball b){
		balls.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b : balls){
			g2.fill(b.getShape());
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
}
