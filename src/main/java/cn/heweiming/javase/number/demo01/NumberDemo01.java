package cn.heweiming.javase.number.demo01;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class NumberDemo01 {

	public int remainder(int dividend, int divisor) {
		return dividend - dividend / divisor * divisor;
	}

	@Test
	public void isEven() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入多个数字判断奇偶");
		while (input.hasNextInt()) {
			int i = input.nextInt();
			String str = i + "->" + (i % 2 == 1 ? "奇数" : "偶数");
			System.out.println(str);
		}
		input.close();
	}

	@Test
	public void testRemainder() {
		int i = remainder(-1, 2);
		System.out.println(i);
	}

	@Test
	public void testDouble() {
		System.out.println(10.00 - 9.60);
	}

	@Test
	public void testFormat() throws ParseException {
		// NumberFormat format = new DecimalFormat("#.##");
		// System.out.println(format.format(10.00 - 9.60));

		Double d1 = 23323.3323232323;
		Double d2 = 0.3434;
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(4);
		String formatStr = format.format(d1);
		System.out.println(formatStr);
		System.out.println(format.parse(formatStr));
	}

	@Test
	public void testOrder() {
		int limit = 2000;
		int cur = 1000;
		System.out.println(Integer.MAX_VALUE);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要预订的数量: ");
		while (input.hasNextInt()) {
			int order = input.nextInt();
			if (order > 0 && order + cur <= limit) {
				System.out.println("你已经成功预订了" + order + "个产品");
			} else {
				System.out.println("超过限额，预订失败！ ");
			}
		}
	}

	@Test
	public void testRound() {
		// 正无穷方向舍入规则
		System.out.println("10.5近似值: " + Math.round(10.5));
		System.out.println("-10.5近似值: " + Math.round(-10.5));
	}

	@Test
	public void testBox() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		int count = 0;
		for (Integer i : list) {
			count += i;
		}
		System.out.println(count);
	}

}
