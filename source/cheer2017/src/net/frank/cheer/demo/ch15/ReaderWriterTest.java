package net.frank.cheer.demo.ch15;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ReaderWriterTest {
	public static void main(String[] args){
		JFrame f = new TextEditorFrame();
		f.setVisible(true);
	}
}

class TextEditorFrame extends JFrame{
	
	private static File editorFile = new File("E:/zhaofeng/test/editor.txt");
	
	public TextEditorFrame(){
		setTitle("Text Editor");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		final JTextArea content = new JTextArea();
		add(content,BorderLayout.CENTER);
		
		JButton readerButton = new JButton("Reader");
		JButton writerButton = new JButton("Writer");
		
		readerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileReader reader = null;
				try{
					reader = new FileReader(editorFile);
					char[] _content = new char[1024];
					int flag = -1;
					StringBuilder sb = new StringBuilder();
					while((flag = reader.read(_content))!=-1){
						String eachContent = new String(_content,0,flag);
						sb.append(eachContent);
					}
					content.setText(sb.toString());
				}catch(Exception ee){
					
				}finally{
					try{
						if(reader!=null){
							reader.close();
						}
					}catch(Exception eee){
						
					}
				}
			}
		});
		
		writerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Writer clicked");
			}
		});
		
		
		
		JPanel southPanel = new JPanel();
		
		southPanel.setLayout(new GridLayout(1, 2));
		southPanel.add(readerButton);
		southPanel.add(writerButton);
		add(southPanel,BorderLayout.SOUTH);
		
		
		
	}
	
	
}
