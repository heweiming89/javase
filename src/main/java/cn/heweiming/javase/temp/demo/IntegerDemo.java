package cn.heweiming.javase.temp.demo;

import org.junit.Test;

public class IntegerDemo {

	@Test
	public void getPage() {
		int total = 100;
		int size = 8;
		System.out.println(total / 8 + (total % 8 == 0 ? 0 : 1));

	}
}
