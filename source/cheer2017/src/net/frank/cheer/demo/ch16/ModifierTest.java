package net.frank.cheer.demo.ch16;

import java.lang.reflect.Modifier;

public class ModifierTest {

	public static void main(String[] args) {
		
		/**
		 * 
		 * 
		public                 000000001
		private                000000010
		proteceted             000000100
		static		       	   000001000
		final                  000010000
		
		exmaple
		public stitic          000001001
		public static final    000011001 
		 * 
		 */
		
		int mod = 0x11; // 17 public 1, final 16
		
		System.out.println(Modifier.toString(mod));
		mod = 0x19; // 17 public 1, 8 static,  final 16 
		System.out.println(Modifier.toString(mod));
		 
	}
	
}