package net.frank.cheer.ch01;

// if not below java.lang, it need to import
import java.util.Date;

public class HelloWorld{
	
	private static final float PI = 3.14f;
	
	public static void main(String[] args){
		System.out.println("Hello World. Just now is " + new Date() );	
	
	}
	
	
	public static double calendC(int r){
		int two = 2;
		return PI * r * two;
	}
	
	public static double calendS(int r){
		return PI * (r*r);
	}
}