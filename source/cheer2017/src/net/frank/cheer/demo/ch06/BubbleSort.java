package net.frank.cheer.demo.ch06;

public class BubbleSort {

	public static void main(String[] args) {
		
		int [] values = new int[6];
		values[0] = 8;
		values[1] = 39;
		values[2] = 17;
		values[3] = 78;
		values[4] = 82;
		values[5] = 52;
		
		
		for(int i=1;i<values.length;i++){
			for(int j=0;j<i;j++){
				if(values[i]<values[j]){
					int temp = values[i];
					values[i] = values[j];
					values[j] = temp;
				}
				printArray(values);
			}
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
 