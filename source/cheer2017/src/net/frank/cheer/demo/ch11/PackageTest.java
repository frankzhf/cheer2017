package net.frank.cheer.demo.ch11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.frank.cheer.framework.DateUtil;

public class PackageTest {
	
	public static void main(String[] args){
		System.out.println(DateUtil.firstDateForMonth(new Date()));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//df.parse("2017-05-14");
	}
}
