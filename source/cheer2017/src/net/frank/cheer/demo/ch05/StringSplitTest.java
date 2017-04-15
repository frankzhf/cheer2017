package net.frank.cheer.demo.ch05;

class StringSplitTest {

	public static void main(String[] args) {
		//cvs
		String row = "zhaofeng,37,nan";
		String [] values = row.split(",");
		
		for(String value : values){
			System.out.println(value);
		}
		
		 values = row.split(",",2);
		 for(String value : values){
				System.out.println(value);
			}
		
	}

}
