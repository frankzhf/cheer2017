package net.frank.cheer.demo.ch09;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal("11.11111111");
		BigDecimal result = b1.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
		
		//MathContext mc = new MathContext(7,RoundingMode.HALF_UP);
		
		result = b1.divide(new BigDecimal("1.11"),MathContext.UNLIMITED);
		
		//result = b1.divide(new BigDecimal("1.11"),mc);
	}

}
