package net.frank.cheer.demo.ch05;

public class ToStringTest {
	public static void main(String[] args){
		Test test = new Test();
		
		/*** stack
		 * 
0x000001* 	none 0x11000 ----- 
		 * 					|
0x000010* 	none 0x10000 -- |
0x000010 * 	b	 0x11100 --||
		 * 	heap     	  |	|
0x100000 * 	a       <--------
		 * 				  |
0x110000 *  b      <--------
0x111000 *  ab
		 *
		 */
		/***
		 * 	 worldhello
		 * 
		 */
		
		// *Test p = 
		
		//p++ 
		//p --
		
		System.out.println(test);
	}
}


class Test{
	
}
