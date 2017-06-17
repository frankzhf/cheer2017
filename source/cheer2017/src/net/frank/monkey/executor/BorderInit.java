package net.frank.monkey.executor;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

class BorderInit extends JFrame {
	private static final long serialVersionUID = -8232999379756338989L;
	
	private transient Logger log = Logger.getLogger(BorderInit.class);
	
	public JLabel jlbImg;
	private boolean flag;

	public boolean getFlag() {
		return this.flag;
	}

	public BorderInit(String ip) {
		this.flag = true;
		this.jlbImg = new JLabel();
		setTitle("Remote--IP:" + ip);
		double width = Toolkit.getDefaultToolkit().getScreenSize().width;
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize((int) width, (int) height);

		add(this.jlbImg);
		setLocationRelativeTo(null);
		setExtendedState(6);
		setDefaultCloseOperation(2);
		setVisible(true);
		validate();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				BorderInit.this.flag = false;
				BorderInit.this.dispose();
				log.info("Close connect");
				System.gc();
			}
		});
	}
}
