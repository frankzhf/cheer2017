package net.frank.cheer.demo.ch09;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
	public static void main(String [] args) throws Exception{
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		
		date = new Date(2017,4,1);
		System.out.println(date);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(df.format(new Date()));
		
		Date _data = df.parse("28/04/2017 16:30:31");
		
		
		System.out.println(df.format(_data));
		
		
		Calendar c = Calendar.getInstance();
		
		//Calendar gc = new GregorianCalendar();
		
		c.setTime(_data);
		c.add(Calendar.DAY_OF_MONTH,-7);
		
		System.out.println(c.getTime());
		
	}
}
