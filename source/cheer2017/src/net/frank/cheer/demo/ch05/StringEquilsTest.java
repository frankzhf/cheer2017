package net.frank.cheer.demo.ch05;

public class StringEquilsTest {
	public static void main(String[] args){
		
		String str ="abc";
		String str1 = "abc";
		
		boolean rt = str.equals(str1);
		
		int intRt = str.compareTo(str1);
		
		System.out.println(rt);
		
		System.out.println(intRt);
		
		byte[] bytes = str.getBytes();
		
		byte[] bytes1 = new byte[str.length()];
		
		str.getBytes(0,str.length(),bytes1,0);
		
		
		
		
	}
}
