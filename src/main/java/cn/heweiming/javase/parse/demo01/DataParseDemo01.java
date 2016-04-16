package cn.heweiming.javase.parse.demo01;

import org.junit.Test;

public class DataParseDemo01 {

	@Test
	public void testParse01() {
		// 0021602260300000010000|刘昌盛|001|420624199104287919||1900-01-01||1900-01-01|1900-01-01||||
		// 0021602260300000040000|王颖|001|340111197712021024|1990301011022891729|2015-01-12|.1200|.1200|0.00|0.00|
		// 000|111|222|333|444|555|666|777
		String data = "000|111||333|444|||";
		String[] fields = data.split("\\|");
		System.out.println(fields.length);
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			System.out.println(field.isEmpty() + "\t" + field);
		}
	}

	@Test
	public void testParse02() {
		String data = " abc 341243 fdsafds";
		String[] strings = data.split(" ");
		for (String string : strings) {
			System.out.println(string);

		}
	}

	@Test
	public void testControl01() {
		int i = (int) (Math.random() * 3);
		System.out.println(i);
		System.out.println("-------------------");
		switch (i) {
		case 0: {
			System.out.println(00000);
		}
			System.out.println("43143241");
			break;
		case 1:
			System.out.println(111);
			System.out.println(111111);
			break;
		case 2:
			System.out.println(222);
			System.out.println(222222);
			break;
		default:
			break;
		}

	}

}
