package net.frank.cheer.demo.ch04;

public class ForEach {

	public static void main(String[] args) {
		int[] array = new int[]{
			1,2,3,4,5,6,7,8,9,10	
		};
		for(int value : array){
			if(value == 5){
				continue;
			}
			System.out.println(value);
			
		}
	}

}
