package cn.heweiming.javase.string.demo01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class StringDemo01 {

	@Test
	public void getStrLength() {
		String str1 = "﻿0021602260300000040000";
		String str2 = "0021602260300000040000";
		// str1.replace("\r", "");
		// str1.replace("\n", "");
		System.out.println("str1长度\t" + str1.length());
		// char[] array = str1.toCharArray();
		// for (char c : array) {
		// System.out.println(c);
		// }
		System.out.println("str2长度\t" + str2.length());
		System.out.println(str1.equals(str2));

	}

	@Test
	public void parseStr() throws IOException {
		File file = new File("D:/CREDIT_RES_ACC_2016041501.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
				file)));
		String dataStr = "";
		while ((dataStr = br.readLine()) != null) {
			String[] strings = dataStr.split("\\|");
			for (String string : strings) {
				string.replace("\r", "");
				string.replace("\n", "");
				System.out.println(string + "\t" + string.trim().length());
			}
			for (int i = 0; i < strings.length; i++) {

			}
			System.out.println("=================================");
		}

		// String dataStr =
		// "0021602260300000040000|王颖|001|340111197712021024|1990301011022891729|2015-01-12|.1200|.1200|0.00|0.00|";
		// String[] strings = dataStr.split("\\|");
		// for (String string : strings) {
		// System.out.println(string.length());
		// }
		br.close();
	}

	@Test
	public void test01() {

	}

	@Test
	public void testAppend1() {
		long begin = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100000; i++) {
			sb.append("中国梦");
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Test
	public void testAppend2() {
		long begin = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			sb.append("中国梦");
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Test
	public void testConcat() {
		long begin = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < 100000; i++) {
			str.concat("中国梦");
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Test
	public void testContains() {
		// String prefix = "_PROCESSED";
		// String suffix = "_ERROR";
		// String name = prefix + suffix;
		// System.out.println(name.contains(prefix));
		// System.out.println(name.contains(suffix));

		String str = "fdafdsafsf.fdsafds.4321432.6423534";
		boolean b = str.contains(".");
		System.out.println(b);
	}

	@Test
	public void testEquals() {
		String str1 = "中国";
		String str2 = "中国";
		String str3 = new String("中国");
		String str4 = str3.intern();
		boolean b1 = str1 == str2;
		boolean b2 = str1 == str3;
		boolean b3 = str1 == str4;

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}

	@Test
	public void testEqualsStr() {
		String str1 = "431432412.txt";
		String str2 = "fgsdfafs.txt";
		String[] strs1 = str1.split("\\.");
		// String[] strs2 = str2.split("\\.");
		System.out.println(strs1.length);
		System.out.println(str1.split("\\.")[1].equals(str2.split("\\.")[1]));

	}

	@Test
	public void testFormat() {
		// String template = "";
		Calendar c = Calendar.getInstance();
		String s = String.format("Duke's Birthday:%1$tY年%1$tm月%1$te日,", c);
		s = String.format("%1$tF %1$tT", c);
		System.out.println(s);

	}

	@Test
	public void testGetByte() {
		String str = "范";
		System.out.println(str.getBytes().length);
	}

	@Test
	public void testPattern() {
		String str = "曾阿牛|男|27||";
		Pattern pattern = Pattern.compile("\\b\\w+\\b");
		Matcher matcher = pattern.matcher(str);
		int fieldCount = 0;
		while (matcher.find()) {
			String group = matcher.group();
			System.out.println(group);
			fieldCount++;
		}
		System.out.println(fieldCount);

	}

	@Test
	public void testPlus() {
		long begin = System.currentTimeMillis();
		@SuppressWarnings("unused")
		String str = "";
		for (int i = 0; i < 100000; i++) {
			str += "中国梦";
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Test
	public void testRex() {
		String number = "-5";
		System.out.println(number.matches("\\d*"));
	}

	@Test
	public void testSpilt() {
		String dataStr = "曾阿牛|男|27||";
		int i = dataStr.split("\\b\\|\\b").length;
		System.out.println(i);
	}

	@Test
	public void testSplit() {
		String str = "4321432.4321432.44321";
		String[] strings = str.split("\\.");
		System.out.println(strings.length);
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void testSubStr() {
		String str = "0123456";
		str = "0";
		int length = str.length();
		String string = str.substring(length - 2, length);
		System.out.println(string);
	}

	@Test
	public void testSuffix() {
		String partten = "_HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		String format = sdf.format(new Date());
		System.out.println(format);
	}

	@Test
	public void testCollator() {
		String[] strs = { "张三(Z)", "李四(L)", "王五(W)" };
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		try {
			Comparator<Object> comparator = Collator.getInstance(Locale.CHINA);
			Arrays.sort(strs, comparator);
			System.out.println(Arrays.toString(strs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
