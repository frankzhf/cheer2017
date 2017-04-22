package net.frank.cheer.demo.ch08;

public class EquailsExcludeTest {
	
	
	public static void main(String[] args){
		/**
		Integer i = 10000;
		Integer j = 10000;
		***/
		Integer i = 127;
		Integer j = 127;
		
		if(i.equals(j)){
			System.out.println("i equals j");
		}
		
		if(i == j){
			System.out.println("i == j");
		}
		
		
	}
	
}
