package net.frank.cheer.demo.ch06;

public class SelectSort {
	public static void main(String[] args){
		int [] arr = {6,3,8,2,9,1};
		System.out.println("排序前");
		printArray(arr);
		int index;
		for(int i=1;i<arr.length;i++){
			index=0;
			for(int j=1;j<=arr.length -i;j++){
				if(arr[j] > arr[index]){
					index = j;
				}
			}
			int temp = arr[arr.length-i];
			arr[arr.length-i] = arr[index];
			arr[index] = temp;
			printArray(arr);
		}
		System.out.println("排序前");
		printArray(arr);
	}
	
	private static void printArray(int[] arr){
		for(int num:arr){
			System.out.print(num + "\t");
		}
		System.out.println();
	}
}
