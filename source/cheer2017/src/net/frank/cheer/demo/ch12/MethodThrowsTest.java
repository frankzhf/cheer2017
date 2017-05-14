package net.frank.cheer.demo.ch12;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodThrowsTest {

	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		/***
		try{
			df.parse("2017-05-14");
		}catch(ParseException e){
			
		}
		***/
		Date date = df.parse("2017-05-14");
		System.out.println(date);
	}

}
