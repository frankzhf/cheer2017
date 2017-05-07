package net.frank.cheer.demo.ch04;

import java.io.IOException;
import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args)throws IOException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Score:" );
		int sorce = scanner.nextInt(); 
		
		switch(sorce){  //1.6 onlhy process int|byte|short|char   
						//1.7 all 
			case 60:
				System.out.println("Leval 1");
				System.out.println("do others");
			break;
			case 70:
				System.out.println("Leval 2");
			break;
			case 80:
				System.out.println("Leval 3");
			break;
			case 90:
				System.out.println("Leval 4");
			break;
			case 100:
				System.out.println("Leval 5");
			break;
			default:
				System.out.println("Leval 0");
		}
		
		scanner.close();
		
	}
}
