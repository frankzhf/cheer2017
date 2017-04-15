package net.frank.cheer.demo.ch05;

public class StringConnectTest {
	public static void main(String[] args){
		String str1 = "China,";
		String str2 = "I Love you";
		Demo demo = new Demo();
		String str3 = str1+ str2 + 0 + " " + 0.0d + "" + demo;
		System.out.println(str3);
	}
}

class Demo{
	public String toString(){
		return "demo";
	}
}
