package net.frank.cheer.demo.ch09;

import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		//Integer i = new Integer("1000000000000000000000");
		//System.out.println(i);
		
		BigInteger bi = new BigInteger("1000000000000000000000");
		System.out.println(bi);
		
		BigInteger result = bi.add(new BigInteger("200000000000000000000"));
		
		System.out.println(result);
		
		result = bi.subtract(new BigInteger("200000000000000000000"));
		
		System.out.println(result);
		
		result = bi.multiply(new BigInteger("20000000000000000"));
		
		System.out.println(result);
		
		result = bi.divide(new BigInteger("100"));
		
		System.out.println(result);
		
		
	}
}