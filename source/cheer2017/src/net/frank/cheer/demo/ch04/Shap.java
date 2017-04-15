package net.frank.cheer.demo.ch04;

import java.util.Scanner;

public class Shap {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入菱形的边长：");
		
		Scanner scanner = new Scanner(System.in);
		
		int width = scanner.nextInt();
		
		char space = ' ' ;
		int start =0;
		int end = 0;
		for(int i=0;i<width;i++){
			start = width-i-1;
			end = start +i*2;
			for(int j=0;j<=end;j++){
				if(j==start){
					System.out.print('*');
				}else if(j==end){
					System.out.print('*');
				}else{
					System.out.print(space);
				}
				
			}
			System.out.print('\n');
		}
		for(int i=width-2;i>-1;i--){
			start = width-i-1;
			end = start +i*2;
			for(int j=0;j<=end;j++){
				if(j==start){
					System.out.print('*');
				}else if(j==end){
					System.out.print('*');
				}else{
					System.out.print(space);
				}
				
			}
			System.out.print('\n');
			
			scanner.close();
		}
		

		/**
		 *                    0123456789
		     *                    4
		    * *                  3 5
		   *   *                2   6
		  *     *              1     7
		 *       *            0       8 
		  *     *	           1     7
		   *   *
		    * *
		     *	    		 
		 * 
		 * 
		 */
		
	}
}
