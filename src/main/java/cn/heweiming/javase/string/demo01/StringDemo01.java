package cn.heweiming.javase.string.demo01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class StringDemo01 {

	@Test
	public void test01() {

	}

	@Test
	public void testGetByte() {
		String str = "范";
		System.out.println(str.getBytes().length);
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
	public void testEqualsStr() {
		String str1 = "431432412.txt";
		String str2 = "fgsdfafs.txt";
		String[] strs1 = str1.split("\\.");
		String[] strs2 = str2.split("\\.");
		System.out.println(strs1.length);
		System.out.println(str1.split("\\.")[1].equals(str2.split("\\.")[1]));

	}

	@Test
	public void parseStr() throws IOException {
		File file = new File("D:/CREDIT_RES_ACC_2016041501.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
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
	}

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
	public void testSuffix() {
		String partten = "_HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		String format = sdf.format(new Date());
		System.out.println(format);
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
	public void testSpilt() {
		String dataStr = "曾阿牛|男|27||";
		int i = dataStr.split("\\|").length;
		System.out.println(i);
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
	public void testFormat() {
		String template = "";
		Calendar c = Calendar.getInstance();
		String s = String.format("Duke's Birthday:%1$tY年%1$tm月%1$te日,", c);
		s = String.format("%1$tF %1$tT", c);
		System.out.println(s);

	}

}
