package net.frank.cheer.demo.ch06;

public class CompareTest {

	public static void main(String[] args) {
		/***
		
		int a= 10;
		int b= 20;
		int c= 30;
		int d= 40;
		
		if (a >b ){
			if(a>c){
				
			}
		}else{
			if(b>c){
				
			}
		}
		***/
		
		
		int [] values = new int[6];
		values[0] = 8;
		values[1] = 39;
		values[2] = 17;
		values[3] = 78;
		values[4] = 82;
		values[5] = 52;
		/***
		int max=-1;
		for(int value:values){
			if(value > max){
				max = value;
			}
		}
		System.out.println(max);
		*/
		
		int max = -1;
		int maxIndex = -1;
		for(int i =0;i<values.length;i++){
			int value = values[i];
			if(value > max){
				max = value;
				maxIndex = i;
			}
		}
		int temp = values[values.length-1];
		values[values.length-1] = max;
		values[maxIndex] = temp;
	
		
	}

}
