package net.frank.cheer.sample.ch04;

import java.util.Date;

public class DemoTest2 {
	
	static float PI = 3.1415f;
	
	public static void main(String[] args){
		int i = 10;
		//i ++ ;  // i=i+1
		System.out.println(i++);   //System.out.println(i); i=i+1
		//i --;	// i=i-1
		System.out.println(i--);	//System.out.println(i); i=i-1
		System.out.println(++i);	// i=i+1 ;System.out.println(i);
		System.out.println(--i);	// i=i-1 ;System.out.println(i);
		long ll = 1000000;
		long  l = i + ll;
		
		System.out.println(l);
	}
	
	
	public static float caleCyc(float r){
		return r*2*PI;
	}
	
	public static float caleAraa(float r){
		return r*r*PI;
	}
	
	
}
