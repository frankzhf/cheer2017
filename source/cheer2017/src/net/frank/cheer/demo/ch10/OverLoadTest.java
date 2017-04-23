package net.frank.cheer.demo.ch10;

public class OverLoadTest {
		
	private double PI = 3.14;
	
	public OverLoadTest(){
		this(3.14);
	}
	
	public OverLoadTest(double pi){
		System.out.println("new OverLoadTest()");
		this.PI = pi;
	}
	
	public double caleCyc(double r){
		return 2*r*PI;
	}
	
	public double caleArea(double r){
		return r*r*PI;
	}
	
	

	
	public static void main(String[] args) {
		
		OverLoadTest test01 = new OverLoadTest();
		System.out.println(test01.caleCyc(10));
		System.out.println(test01.caleArea(10));
		
		OverLoadTest test02 = new OverLoadTest(3.1415626);
		System.out.println(test02.caleCyc(10));
		System.out.println(test02.caleArea(10));
		
		
	}

}
