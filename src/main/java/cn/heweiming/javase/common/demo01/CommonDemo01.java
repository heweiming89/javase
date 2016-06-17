package cn.heweiming.javase.common.demo01;

import org.junit.Test;

public class CommonDemo01 {

	@Test
	public void test01() {
		int number = 1;
		System.out.println("1乘以2= \t" + (number << 1));
		System.out.println("1乘以4= \t" + (number << 2));
		System.out.println("1乘以8= \t" + (number << 3));
		System.out.println("1乘以16= \t" + (number << 4));
		System.out.println("1乘以32= \t" + (number << 5));
	}

	@Test
	public void testSwap() {
		int a = 2;
		int b = 7;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a);
		System.out.println(b);
	}

	@Test
	public void testSwap02() {
		int a = 2;
		int b = 7;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("a -> " + a);
		System.out.println("b -> " + b);
	}

	@Test
	public void testLeapYear() {
		int year = 2000;
		boolean b = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
		System.out.println(b == true ? year + "是闰年" : year + "不是闰年");
		boolean b2 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

}
