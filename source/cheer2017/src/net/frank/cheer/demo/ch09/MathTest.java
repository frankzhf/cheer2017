package net.frank.cheer.demo.ch09;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MathTest {

	public static void main(String[] args) {
		//Math math = new Math();
		
		NumberFormat nf = new DecimalFormat("0.00");
		
		System.out.println(
				nf.format(
						Math.sin(Math.PI*30/180)
				));
		
		Math.cos(Math.sin(Math.PI*30/180));
		
		
	}

}

/***
class MyMath extends Math{
	
}
***/

class Student{
	
	private Student(){
		
	}
	
	
}