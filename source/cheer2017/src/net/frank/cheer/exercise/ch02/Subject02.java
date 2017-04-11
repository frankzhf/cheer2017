package net.frank.cheer.exercise.ch02;

import java.util.Scanner;

public class Subject02 {
	public static void main(String[] args)throws Exception{
		int one=-1,two =-1;
		Scanner scanner = null;
		while(one==-1 || two==-1){
			System.out.print("Please enter number:");
			scanner = new Scanner(System.in);
			if(scanner.hasNextInt()){
				if(one ==-1){
					one = scanner.nextInt();
				}else{
					two = scanner.nextInt();
				}
			}
		}
		System.out.println();
		System.out.println("a+b=" + (one+two));
		System.out.println("a-b=" + (one-two));
		System.out.println("a*b=" + (one*two));
		System.out.println("a/b=" + (one/two));
		scanner.close();
		
	}
}
