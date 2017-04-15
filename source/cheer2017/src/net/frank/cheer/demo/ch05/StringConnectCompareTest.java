package net.frank.cheer.demo.ch05;

public class StringConnectCompareTest {
	public static void main(String[] args){
		
		long start = System.currentTimeMillis();
		
		String value = "";
		for (int i=0;i<1000;i++){
			value = (value+"a");
		}
		System.out.println(value);
		long end = System.currentTimeMillis();
		System.out.println("finished " + (end-start) + " seconds");
		
		start = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer(30000);
		for (int i=0;i<1000;i++){
			sb.append("a");
		}
		System.out.println(sb.toString());
		end = System.currentTimeMillis();
		System.out.println("finished " + (end-start) + " seconds");
		
		
		start = System.currentTimeMillis();
		StringBuilder sbd = new StringBuilder(30000);
		for (int i=0;i<1000;i++){
			sbd.append("a");
		}
		System.out.println(sbd.toString());
		end = System.currentTimeMillis();
		System.out.println("finished " + (end-start) + " seconds");
		
	}
}
