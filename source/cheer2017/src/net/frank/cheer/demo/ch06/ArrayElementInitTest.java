package net.frank.cheer.demo.ch06;

import java.util.Arrays;
import java.util.Date;

public class ArrayElementInitTest {
	public static void main(String[] args){
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		//arr[5] = 6;
		
		
		int[] newArray =  Arrays.copyOf(arr, 1000);
		
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		Date[] dates = new Date[5];
		
		for(int i=0;i<dates.length;i++){
			dates[i] = new Date();
		}
		
		
		for(int i=0;i<dates.length;i++){
			System.out.println(dates[i].toString());
		}
		
		
	}
}
