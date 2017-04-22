package net.frank.cheer.demo.ch08;

import java.util.ArrayList;
import java.util.List;

public class Base {
	public static void main(String[] args){
		
		int _i =1;
		Integer _j=10;
		
		if(_i ==_j){
			
		}
		
		List list = new ArrayList();
		for (int i=0;i<10;i++){
			//list.add(i);
		}
		
		int _16i = 0xff;
		System.out.println(_16i);
		
		byte _16b = 0x11;
		System.out.println(_16b);
		
		_16b = 0x7f;
		System.out.println(_16b);
		
		_16b = (byte)0xff;
		System.out.println(_16b);
		
		
		int value = 10;
		System.out.println(Integer.toString(value));
		
		value = 16;
		System.out.println(Integer.toString(value,16));
		
		
		value = 255;
		System.out.println(Integer.toHexString(value));
	
	}
}
