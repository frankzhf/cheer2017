package net.frank.cheer.demo.ch09;

public class RandomTest {

	public static void main(String[] args) {
		int n =1000;
		for (int i=0;i<100;i++){
			int value = (int) (Math.random()*n);
			System.out.println(value);
		}
	}

}
