package net.frank.cheer.demo.ch06;

public class SelectSort {

	public static void main(String[] args) {
		
		int [] values = new int[6];
		values[0] = 8;
		values[1] = 39;
		values[2] = 17;
		values[3] = 78;
		values[4] = 82;
		values[5] = 52;
		
		for (int i = 0;i<values.length-1;i++ ){
			int max = -1;
			int maxIndex = -1;
			for(int j =0;j<values.length-i;j++){
				int value = values[j];
				if(value > max){
					max = value;
					maxIndex = j;
				}
			}
			int temp = values[values.length-i-1];
			values[values.length-i-1] = max;
			values[maxIndex] = temp;
			
			
			printArray(values);
		}
		printArray(values);
	}
	
	private static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
	
}
