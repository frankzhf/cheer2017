package net.frank.cheer.demo.ch06;

public class CompareTest {

	public static void main(String[] args) {
		/***
		int a = 10;
		int b = 20;
		int c = 30;
		int d,e,f;
		
		
		
		
		if(a >= b){
			if(a>=c){
				System.out.println("max is a");
			}else{
				System.out.println("max is c");
			}
			
			
		}else{
			if(b>=c){
				System.out.println("max is b");
			}else{
				System.out.println("max is c");
			}
		}
		
		***/
		
		/***
		int [] values = new int[6];
		values[0] = 8;
		values[1] = 39;
		values[2] = 17;
		values[3] = 78;
		values[4] = 82;
		values[5] = 52;
		
		int max=-1;
		for(int value:values){
			if(value > max){
				max = value;
			}
		}
		System.out.println(max);
		***/
		/***
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
		***/
		
		int a = 10;
		int b = 20;
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		
		/**
		int tmp = -1;
		tmp = a;
		a = b;
		b = tmp;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		***/
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		
	}

}
