package net.frank.cheer.demo.ch11;

public class InnerClassTest {
	
	private int value;
	
	private void process(){
		System.out.println("Call process");
	}
	
	class InnerClass{
		public InnerClass(){
			value = 101;
			process();
		}
	}
	
	public void processInnnerClass(){
		class Inner2Class{
			public Inner2Class(){
				value = 101;
				process();
			}
		}
	}
	
	public static void main(String[] args){
		
		
	}
}
