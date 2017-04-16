package net.frank.cheer.demo.ch07;

public class ObjectCompareTest {
	public static void main(String[] args){
		CompareDemo demo1 = new CompareDemo(); 
		
		CompareDemo cloneObject = demo1.clone();
		
		
		demo1.setValue(101);
		
		System.out.println(demo1.getValue());

		System.out.println(cloneObject.getValue());
		
	}
}

class CompareDemo implements Cloneable {
	private int value = 1000;
	
	public CompareDemo() {
	
	}
	
	
	public CompareDemo(int value) {
		this.value = value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	
	public boolean equals(CompareDemo obj) {
		return this.value == obj.value;
	}
	
	public CompareDemo clone() {
		try{
			Object obj = super.clone();
			
			if(obj instanceof CompareDemo){
				return  (CompareDemo)obj;
			}
			
		}catch(CloneNotSupportedException e){
			
		}
		return null;
	}
	
}