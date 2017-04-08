package net.frank.cheer.ch02;

public class Shap {

	public static void main(String[] args) {
		
		int width = 5;
		
		/**
		 * 
		     *                      4
		    * *                    3 5
		   *   *
		  *     *
		 *       *
		  *     *
		   *   *
		    * *
		     *	    		 
		 * 
		 * 
		 */
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
		}
	}
}
