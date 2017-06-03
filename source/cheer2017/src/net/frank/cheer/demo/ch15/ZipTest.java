package net.frank.cheer.demo.ch15;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class ZipTest {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				ZipTestFrame frame = new ZipTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});

	}
	
}

class ZipTestFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5407223920994639886L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIHGT = 300;
	private JComboBox<String> fileCombo;
	private JTextArea fileText;
	private String zipname;
	
	public ZipTestFrame(){
		setTitle("ZipTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIHGT);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				int r = chooser.showOpenDialog(ZipTestFrame.this);
				if(r == JFileChooser.APPROVE_OPTION){
					zipname = chooser.getSelectedFile().getPath();
					fileCombo.removeAllItems();
					scanZipFile();
				}
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		fileText = new JTextArea();
		fileCombo = new JComboBox<String>();
		fileCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				loadZipFile(fileCombo.getItemAt(
						fileCombo.getSelectedIndex()));
			}
		});
		add(fileCombo,BorderLayout.SOUTH);
		add(new JScrollPane(fileText),BorderLayout.CENTER);
		
	}
	
	public void scanZipFile(){
		new SwingWorker<Void,String>(){
			@Override
			protected Void doInBackground() throws Exception {
				ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
				ZipEntry entry;
				while((entry = zin.getNextEntry())!=null){
					publish(entry.getName());
					zin.closeEntry();
				}
				zin.close();
				return null;
			}
			
			protected void process(List<String> names){
				for(String name:names){
					fileCombo.addItem(name);
				}
			}
		}.execute();
	}
	
	public void loadZipFile(final String name){
		fileCombo.setEnabled(false);
		fileText.setText("");
		new SwingWorker<Void,Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				try{
					ZipInputStream zin = new ZipInputStream(
							new FileInputStream(zipname));
					ZipEntry entry;
					while((entry=zin.getNextEntry())!=null){
						if(entry.getName().equals(name)){
							Scanner in = new Scanner(zin);
							while(in.hasNext()){
								fileText.append(in.nextLine());
								fileText.append("\n");
							}
							in.close();
							zin.closeEntry();
							break;
						}
						zin.closeEntry();
					}
					zin.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				return null;
			}
			
			protected void done() {
				fileCombo.setEnabled(true);
			}
		}.execute();
	}
}

/***
 * Class java.util.zip.ZipInputStream
 * ZipInputStrem(InputStream in)
 * 閸掓稑缂撴稉锟芥稉鐚宨pInputStream, 娴ｅ灝绶遍幋鎴滄粦閸欘垯浜掔紒娆忕暰閻ㄥ嚘nputStream閸氭垵鍙炬稉顓烇綖閸忓懏鏆熼幑锟�
 * 
 * ZipEntry getNextEntry()
 * 娑撹桨绗呮稉锟芥い纭呯箲閸ョ�俰pEntry鐎电钖勯敍灞剧梾閺堝娲挎径姘辨畱妞よ妞傛潻鏂挎礀null
 * 
 * void closeEntry()
 * 閸忔娊妫存潻娆庨嚋Zip閺傚洣娆㈡稉顓炵秼閸撳秵澧﹀锟介惃鍕��
 * 
 * 
 * Class java.util.zip.ZipOutputStream
 * ZipOutputStrem(OutputStream out)
 * 閸掓稑缂撴稉锟芥稉顏勭殺閸樺缂夐弫鐗堝祦閸愭瑥鍤崚鐗堝瘹鐎规氨娈慜utputStream閻ㄥ垙ipOutputStream
 * 
 * void putNextEntry(ZipEntry ze)
 * 鐏忓棙瀵氱�规氨娈慫ipEntry娑擃厾娈戞穱鈩冧紖閸愭瑥鍤崚鐗堢ウ娑擃叏绱濋獮璺虹暰娑撹櫣鏁ゆ禍搴″晸閸戠儤鏆熼幑顔炬畱濞翠緤绱濊ぐ鎾圭殶閻⑩暢rite閺傝纭堕弮璁圭礉閺佺増宓侀崣顖欎簰閸愭瑥鍙嗛崚鐗堝瘹鐎规氨娈戝ù浣疯厬
 * 
 * void closeEntry()
 * 閸忔娊妫存潻娆庨嚋zip閺傚洣娆㈡稉顓炵秼閸撳秵澧﹀锟介惃鍕�嶉妴锟�
 * 
 * void setLevel(int level)
 * 鐠佸墽鐤嗛崥搴ｇ敾閻ㄥ嫬鎮囨稉鐙FAULT妞ゅ湱娈戞妯款吇閸樺缂夌痪褍鍩嗛敍宀勭帛鐠併倖妲窪EFAULT_COMPRESSION (-1) 閸欘垯浜掔拋鍓х枂0-9
 * 
 * void setMethod(int method)
 * 鐠佸墽鐤嗛崥搴ｇ敾閸樺缂夐弬瑙勭《 DEFLATED(0)閿涘TORED(8),姒涙顓婚弰鐤岴FLATED(0)
 * 
 * 
 * Class java.util.zip.ZipEntry
 * ZipEntry(String name)
 * 閺嬪嫰锟斤拷
 * 
 * long getCrc()
 * 鏉╂柨娲朇RC32閺嶏繝鐛欓崪宀�娈戦崐锟�
 * 
 * String getName()
 * 鏉╂柨娲栨潻娆庣妞ゅ湱娈戦崥宥囆�
 * 
 * long getSize()
 * 鏉╂柨娲栨潻娆庣妞ら�涚瑝閸樺缂夐惃鍕亣鐏忓繈锟藉倹鍨ㄩ柈钘夋躬娑撳秴褰查惌銉ф畱閹懎鍠屾稉瀣箲閸ワ拷-1
 * 
 * boolean isDirectory()
 * 閺勵垰鎯侀弰顖滄窗瑜帮拷
 * 
 * void setMethod(int method)
 * 閸欏倽顫哯ipOutputStream.setMethod(int method)
 * 
 * void setSize(long size)
 * 鐠佸墽鐤嗘潻娆撱�嶆稉宥堫潶閸樺缂夐惃鍕亣鐏忓骏绱濋崣顏呮箒閸︺劌甯囩紓鈺傛煙濞夋洑璐烻TORED閺冭埖澧犻弰顖氱箑闂囷拷閻拷
 * 
 * void setCrc(long crc)
 * 鐠佸墽鐤咰RC32閺嶏繝鐛欓崪灞伙拷鍌氬涧閺堝婀崢瀣級閺傝纭舵稉绡燭ORED閺冭埖澧犻弰顖氱箑闂囷拷閻拷
 * 
 * Class java.util.zip.ZipFile
 * ZipFile(String file)
 * ZipFile(File file)
 * 閺嬪嫰锟界姴鍤遍弫锟�
 * 
 * Enumeratio entries()
 * 閼惧嘲褰囬幍锟介張澶屾畱ZipEntry
 * 
 * ZipEntry getEntry(String name)
 * 鏉╂柨娲栫紒娆忕暰閸氬秴鐡ч惃鍒廼pEntry,濞屸剝婀佺�电懓绨查弮鎯扮箲閸ョ�梪ll
 * 
 * InputStream getInputStream(ZipEntry ze)
 * 鏉╂柨娲栫紒娆忕暰妞ゅ湱娈慽nputStream
 * 
 * String getName()
 * 鏉╂柨娲栨潻娆庨嚋ZIP閺傚洣娆㈤惃鍕熅瀵帮拷
 * 
 */
