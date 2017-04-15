package net.frank.cheer.demo.ch06;

public class ArrayBaseForeachTest {
	
	
	
	public static void main(String[] args){
		int []  months = new int[]{
			31,29,31,30,31,30,31,31,30,31,30,31	
		};
		
		
		
		for(int i=0;i<months.length;i++){
			int days = months[i];
			System.out.println((i+1)+"ÔÂÓÐ"+days+"Ìì");
		}
		
		
	}
}
