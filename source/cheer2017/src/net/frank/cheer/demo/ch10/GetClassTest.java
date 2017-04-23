package net.frank.cheer.demo.ch10;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class GetClassTest {

	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.getClass().getName());	
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.getClass().getName());
		
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.getClass().getName());
		
		Object o =  new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(o.getClass().getName());
		
		
		if(sdf.getClass().equals(SimpleDateFormat.class)){
			System.out.println("getClass:sdf is SimpleDateFormat.class");
		}
		
		if(sdf.getClass().equals(DateFormat.class)){
			System.out.println("getClass:sdf is DateFormat.class");
		}
		if(sdf.getClass().equals(Format.class)){
			System.out.println("getClass:sdf is Format.class");
		}
		if(sdf.getClass().equals(Object.class)){
			System.out.println("getClass:sdf is Object.class");
		}
		
		
		if(sdf instanceof SimpleDateFormat){
			System.out.println("instanceof£ºsdf is SimpleDateFormat.class");
		}
		
		if(sdf instanceof DateFormat){
			System.out.println("instanceof£ºsdf is DateFormat.class");
		}
		if(sdf instanceof Format){
			System.out.println("instanceof£ºsdf is Format.class");
		}
		if(sdf instanceof Object){
			System.out.println("instanceof£ºsdf is Object.class");
		}
		
		
		Object oo = new DecimalFormat("#.00");
		
		formatPrint(o,"2017-04-23");
		formatPrint(oo,111222.11522d);
	}	
	
	
	private static void formatPrint(Object f,Object data) throws Exception{
		
		
		System.out.println(f.getClass().getName());
		System.out.println(data.getClass().getName());
		
		if(f instanceof DateFormat 
				|| f instanceof SimpleDateFormat){
			DateFormat formatter = (DateFormat) f;
			if(data instanceof String){
				String date = (String) data;
				System.out.println(formatter.parse(date));
			}
		}else if(f instanceof NumberFormat 
				|| f instanceof DecimalFormat ){
			DecimalFormat formatter = (DecimalFormat)f;
			if(data instanceof Number){
				
				System.out.println(formatter.format(data));
			}
		}
		
		
	}
	
	
}
