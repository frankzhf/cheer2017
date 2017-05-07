package net.frank.cheer.demo.ch07;

import java.util.Arrays;

public final class StaticTest {
	private static int count = 0;
	
	public  static double PI = 3.1415926f;
	
	public StaticTest(){
		System.out.println("new StaticTest called.");
		count ++;
	}
	
	public static void main(String[] args) {
		
		StaticTest.PI = 3.14;
		
		StaticTest t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();
		t = new StaticTest();

		
		System.out.println("count new method call " +StaticTest.count+ " times ");
	}

}
