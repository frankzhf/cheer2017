package net.frank.cheer.demo.ch06;

import java.util.Arrays;

public class ArrayFillTest {
	public static void main(String[] args){
		
		//int[] array = new int[10];
		
		int[] array = new int[]{
			100,100,100,100,100,100,100,100,100,100,100,100
		};
		
		//int[] copyArray = Arrays.copyOf(original, newLength)
		
		
		String a = new String("abc");
		
		
		printArray(array);

		
		Arrays.fill(array, 100);
		
		printArray(array);
		
	}
	
	
	private static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	
}
