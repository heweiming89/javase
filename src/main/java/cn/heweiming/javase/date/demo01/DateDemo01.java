package cn.heweiming.javase.date.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateDemo01 {

	@Test
	public void testDate01() {
		String dateStr = String.format("%1$tF %1$tT:%1$tL", new Date());
		System.out.println(dateStr);
	}

	@Test
	public void compareDate() {
		Date date1 = new Date(System.currentTimeMillis() - 1);
		Date date2 = new Date();
		System.out.println(date1.compareTo(date2));
	}

	@Test
	public void formatDate() throws ParseException, InterruptedException {
		Date date = new Date();
		System.out.println(date.getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = dateFormat.parse(dateFormat.format(date));
		System.out.println(date.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTimeInMillis());
		Thread.sleep(1000);
		calendar.add(Calendar.DATE, 1);
		System.out.println(calendar.getTimeInMillis());
	}

	public final static Date addOneDayTime(Date date) {
		System.out.println(date.getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTimeInMillis());
		calendar.add(Calendar.DATE, 1);

		return calendar.getTime();
	}

	@Test
	public void changeDate() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTimeInMillis());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		int second = calendar.get(Calendar.SECOND);
		System.out.println(year + " " + month + " " + day);
		System.out.println(hourOfDay + " " + minute + " " + second);
		calendar.set(Calendar.MONTH, month);
		System.out.println(calendar.get(Calendar.MONTH));
		// calendar.set(, month, date, hourOfDay, minute, second);

		calendar.set(year, month, day, 0, 0, 0);
		// calendar.
		System.out.println(calendar.getTime().getTime());
		System.out.println(calendar.getTimeInMillis());

	}

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
		date = addOneDayTime(date);
		java.sql.Date sDate = new java.sql.Date(System.currentTimeMillis());
		System.out.println(date.getTime());
		// System.out.println(sDate.);

	}

}
