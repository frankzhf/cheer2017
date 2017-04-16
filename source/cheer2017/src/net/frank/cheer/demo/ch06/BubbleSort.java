package net.frank.cheer.demo.ch06;

public class BubbleSort {
	public static void main(String[] args){
		int [] arr = {6,3,8,2,9,1};
		System.out.println("≈≈–Ú«∞");
		printArray(arr);
		for(int i=0;i< arr.length -1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j] > arr[j+1]){
					arr[j] = arr[j]+ arr[j+1];
					arr[j+1] = arr[j] - arr[j+1];
					arr[j] = arr[j] - arr[j+1];
				}
			}
			printArray(arr);
		}
		System.out.println("≈≈–Ú∫Û");
		printArray(arr);
	}
	
	private static void printArray(int[] arr){
		for(int num:arr){
			System.out.print(num + "\t");
		}
		System.out.println();
	}
	
}
