package net.frank.cheer.demo.ch05;

public class StringInit {

	public static void main(String[] args) {
		
		int i = 1;
		int j = 1;
		if( i== j){
			System.out.println("i == j");
		}else{
			System.out.println("i != j");
		}
		
		String str = new String("abc");
		String str1 = "abc";
		
		Object one = new Object();
		Object two = new Object();
		
		if(str == str1){
			System.out.println("str == str1");
		}else{
			System.out.println("str != str1");
		}
		
		if(str.equals(str1)){
			System.out.println("str equals str1");
		}else{
			System.out.println("str not equals str1");
		}
		
		
		char [] chars = new char[3];
		chars[0] = 'a';
		chars[1] = 'b';
		chars[2] = 'c';
		
		String aaa = new String(chars);
		String bbb = new String(chars,0,2);
		String ccc = new String(aaa);
		
		String value = "abcabcabc";
		//[abc]{3}
		//[abc]+
		//[abc]*
		//[abc]?
	}	

}
