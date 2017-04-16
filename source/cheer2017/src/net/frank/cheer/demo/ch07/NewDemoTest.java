package net.frank.cheer.demo.ch07;

public class NewDemoTest {
	public static void main(String[] args){
		Parent p = new Parent();
		
		System.out.println(p);
		
		Child c = new Child();
		System.out.println(c);
		
	}
}

class Parent{
	private int value=0;
	public Parent(){
		this(100);
	}
	
	public final void abc(){
		
	}
	
	public Parent(int i){
		this.value = i;
		System.out.println("call Parent new method");
	}
	
	public String toString(){
		return ""+value;
	}
	
}


class Child extends Parent{
	public Child(){
		System.out.println("call Child new method");
	}
	
	
}

