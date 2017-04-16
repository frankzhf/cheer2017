package net.frank.cheer.demo.ch07;

public final class StaticTest {
	public static int count = 0;
	
	public final static float PI = 3.1415926f;
	
	public StaticTest(){
		System.out.println("new StaticTest called.");
		count ++;
	}
	
	public static void main(String[] args) {
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
