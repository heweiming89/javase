package cn.heweiming.javase.exception.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ExceptionDemo01 {

	@Test
	public void testDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(1460390100000L);
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(calendar.getTime()));
	}

	public static void main(String[] args) throws ParseException {
		// int a = 10;
		// int b = 0;
		// System.out.println(a / b);

		String dateStr = "2016-04-12";
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		System.out.println(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.getTimeInMillis());

	}

}
