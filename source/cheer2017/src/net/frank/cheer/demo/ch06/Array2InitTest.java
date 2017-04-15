package net.frank.cheer.demo.ch06;

public class Array2InitTest {

	public static void main(String[] args) {
		int array [][];
		array = new int[2][];
		
		array[0] = new int[]{1,2,3,4,5};
		array[1] = new int[]{1,2,3,4,5,6,7};
		
		
		//array[2] = new int[30];
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		
	}

}
