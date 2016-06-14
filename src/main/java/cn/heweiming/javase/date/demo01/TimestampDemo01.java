package cn.heweiming.javase.date.demo01;

import java.sql.Time;
import java.sql.Timestamp;

import org.junit.Test;

public class TimestampDemo01 {

	@Test
	public void test01(){
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		System.out.println(stamp.toString());
		Time time = new Time(System.currentTimeMillis());
		System.out.println(time.toString());
		System.out.println(String.format("%1$tF %1$tT", time));
	}
	
}
