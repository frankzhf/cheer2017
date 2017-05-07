package net.frank.cheer.demo.ch05;

public class StringConnectTest {
	public static void main(String[] args){
		String str1 = "China,";
		String str2 = "I Love you";
		Demo demo = new Demo();
		String str3 = str1+ str2 + 0 + " " + 0.0d + "" + demo;
		System.out.println(str3);
		
		String a ="caresasadfasdfcares";
		String b = "a"+"b";  // 3个 String
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a.length());
		System.out.println(b.length());
		a ="ares";
		System.out.println(b.indexOf(a));
		
		/**
		 * int length()  //返回字符串的长度
int indexOf(String substr) //子字符串开始的位置，从0开始
int lastIndexOf(String substr) //子字符串最后一次出现开始的位置，从0开始

char charAt(int index）//返回指定下标的字符，从0开始

		 */
		
		
		String value="hello world";
		System.out.println(value.replace("lo","yo"));
		
		
		
		
	}
}

class Demo{
	public String toString(){
		return "demo";
	}
}
