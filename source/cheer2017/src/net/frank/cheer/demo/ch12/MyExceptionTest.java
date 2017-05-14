package net.frank.cheer.demo.ch12;

import java.util.Scanner;

public class MyExceptionTest{
	public static void main(String[] args)throws MyException {
		
		System.out.println("Please enter your age:");
		Scanner scanner = null;
		try{
			scanner = new Scanner(System.in);
			while(scanner.hasNextInt()){
				int age = scanner.nextInt();
				if(age == -1){
					break;
				}
				if(age < 1 || age > 120 ){
					throw new MyException();
				}
			}
		}finally{
			scanner.close();
		}
	}
}

class MyException extends Exception {
	public MyException(){
		super("Age should be >= 0 and <=120");
	}
}
