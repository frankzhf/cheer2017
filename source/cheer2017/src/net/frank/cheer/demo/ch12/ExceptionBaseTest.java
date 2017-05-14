package net.frank.cheer.demo.ch12;

public class ExceptionBaseTest {
	
	private static void a(){
		b();
	}
	
	private static void b(){
		c();
	}
	
	private static int c(){
		int i=10;
		int j=-1;
		try{
			j = i/10;
			return j;
		}catch(ArithmeticException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			System.out.println(j);
		}
		System.out.println(i);
		return -1;
		
		/***
		 * 
		try{
			复合语句
		}(catch(异常类 类名){
			复合语句
		})* finally{
			复合语句
		}

		 * 
		 * 
		 */
	}
	
	
	public static void main(String[] args) {
		a();
	}
}
