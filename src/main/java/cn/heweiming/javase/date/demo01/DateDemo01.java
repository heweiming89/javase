package cn.heweiming.javase.date.demo01;

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
		Date date1 = new Date(System.currentTimeMillis() -1);
		Date date2 = new Date();
		System.out.println(date1.compareTo(date2));
	}

}
