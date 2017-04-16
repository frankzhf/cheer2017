package net.frank.cheer.demo.ch07;

public class ObjectRefTest {

	public static void main(String[] args) {
		RefObject a = new RefObject();
		a.setValue(100);
		RefObject b = a;
		b.setValue(101);
		
		System.out.println(a.getValue());
	}

}

class RefObject{
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
	
	
}