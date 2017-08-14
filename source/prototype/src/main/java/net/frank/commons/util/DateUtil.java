package net.frank.commons.util;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtil {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-M-d";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-M-d HH:mm:ss";
	public static final String ALIGN_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final double[] LIMITS = { 0, 1, 2 };

	private static final String[] MINUTES_PART =
		{ "", "1 minute ", "{0,number} minutes " };

	private static final String[] SECONDS_PART =
		{ "0 seconds", "1 second", "{1,number} seconds" };

	private static final ChoiceFormat MINUTES_FORMAT =
		new ChoiceFormat(LIMITS, MINUTES_PART);

	private static final ChoiceFormat SECONDS_FORMAT =
		new ChoiceFormat(LIMITS, SECONDS_PART);

	private static final MessageFormat MINUTE_SECONDS =
		new MessageFormat("{0}{1}");

	static {
		MINUTE_SECONDS.setFormat(0, MINUTES_FORMAT);
		MINUTE_SECONDS.setFormat(1, SECONDS_FORMAT);
	}


	public static final long ONE_DAY = 24 * 60 * 60 * 1000;

	public static final SimpleDateFormat _defDateTimeFmt =
		new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);

	public static final SimpleDateFormat _defDateFmt =
		new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	public static String toString(Date date, String format) {

		SimpleDateFormat formatter;

		if ((date == null) || (format == null) || (format.length() == 0)) {
			return null;
		}
		formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Date toDate(String str, String format) {
		if ((str == null)
			|| (str.length() == 0)
			|| (format == null)
			|| (format.length() == 0)) {
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(str, pos);
	}

	public static boolean compare(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return true;
		}
		if (date1 == null || date2 == null)
			return false;
		else
			return date1.getTime() == date2.getTime();
	}

	public static Date toDate(String str) {
		try {
			if (str.indexOf(':') > 0) {
				return _defDateTimeFmt.parse(str);
			} else {
				return _defDateFmt.parse(str);
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public static String currentDateToString(String format) {
		Date date = new Date();
		return toString(date, format);
	}
	
	public static String curDateStr() {
		return _defDateFmt.format(new Date());
	}
	
	public static String curDateTimeStr() {
		return _defDateTimeFmt.format(new Date());
	}

	public static String formatElapsedTime(long millis) {
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		Object[] args = { new Long(minutes), new Long(seconds % 60)};
		return MINUTE_SECONDS.format(args);
	}
	
	
	public static Date getStartOfDay(Date d) {
		if (d == null) {
			return null;
		}

		GregorianCalendar cal = new GregorianCalendar();
		//Date date = new Date();

		cal.setTime(d);
		setTodayOrigin(cal);

		return cal.getTime();
	}

	private static void setTodayOrigin(GregorianCalendar cal1) {
		//GregorianCalendar cal = new GregorianCalendar();

		cal1.set(Calendar.AM_PM, Calendar.AM);
		cal1.set(Calendar.HOUR, 8);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
	}
	
	public static int getDayOfMonth(Date date){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	public static Date getFirstDayOfMonth(Date curDate){
		GregorianCalendar currentDay = new GregorianCalendar();
		currentDay.setTime(curDate);
		//int today = currentDay.get(Calendar.DAY_OF_MONTH);
		int month = currentDay.get(Calendar.MONTH);
		int year = currentDay.get(Calendar.YEAR);

		Calendar thisMonth = Calendar.getInstance();
		thisMonth.set(Calendar.MONTH, month);
		thisMonth.set(Calendar.YEAR, year);
		thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
		thisMonth.set(Calendar.DAY_OF_MONTH, 1);
		thisMonth.set(Calendar.AM_PM, Calendar.AM);
		thisMonth.set(Calendar.HOUR, 0);
		thisMonth.set(Calendar.MINUTE, 0);
		thisMonth.set(Calendar.SECOND, 0);
		thisMonth.set(Calendar.MILLISECOND, 0);
		
		return thisMonth.getTime();
	}
	
	/*��ȡÿ�µ�����*/
	public static int getdaynum(int year,int month){
		int num=31;
		
		if(month == 4||month == 6||month == 9|| month == 11){
			num=30;
		}else if(month==2){
			if((year%4 == 0) && (year%100!=0) || (year%400 == 0)){
				num=29;
			}else{
				num=28;
			}
		}
		return num;
	}
	
	/*��ȡ��һ��*/
	public static Date nextdate(Date date){
		GregorianCalendar calender = new GregorianCalendar();		
		calender.setTime(date);
		
	
		int day = calender.get(Calendar.DAY_OF_MONTH);
		int month = calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		
		int monthdaynum = getdaynum(year,month);
		
		if(monthdaynum==28){
			if(day<28){
				day = day+1;
			}else{
				day = 1;
				month = month + 1;
			}
		}else if(monthdaynum==30){
			if(day<30){
				day = day+1;
			}else{
				day = 1;
				month = month + 1;
			}
		}else if(monthdaynum==29){
			if(day<29){
				day = day+1;
			}else{
				day = 1;
				month = month + 1;
			}
		}else{
			if(day<31){
				day = day+1;
			}else{
				day = 1;
				month = month + 1;
			}	
		}
			
		calender.set(year,month,day);
		
		return calender.getTime();		
	}	
	
	/*��Date��ʱ���趨Ϊ0ʱ0��0��*/
	public static Date zerodate(Date date){
		GregorianCalendar calender = new GregorianCalendar();		
		calender.setTime(date);	
		
		int day = calender.get(Calendar.DAY_OF_MONTH);
		int month = calender.get(Calendar.MONTH);
		int year = calender.get(Calendar.YEAR);
		
		calender.set(year,month,day,0,0,0);		
		return calender.getTime();
	}
}


