package net.frank.cheer.demo.ch06;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] array = new int[8];
		for(int i=0;i<array.length;i++){
			array[i] = i;
		}
		
		int i = Arrays.binarySearch(array,5);
		
		
	}				
	
}

/***
 * 
 * 
 *            1,2,3
 * 
 *  int input 
 *  1   function retrun 0
 *  2   function retrun 1
 *  3   function return 2
 *  
 *  
 *  				4
 *  		
 *  		2				6
 *  
 *  	1		3		5		7
 * 
 *   
 *  
 *  3 
 *  1.5
 *  
 * 		1 ~ 10000         
 *  
 *  
 *  5000
 *  
 * 
 * 2*1024*1024*1024
 * 
 * 
 */


