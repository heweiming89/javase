package cn.heweiming.javase.temp.demo;

import org.junit.Test;

public class StringDemo {

	
	@Test
	public void testStr(){
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.length());
		sb.append("fdssf");
		System.out.println(sb.length());
	}
}
