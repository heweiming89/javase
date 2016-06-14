package cn.heweiming.javase.collection.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ListDemo01 {

	@Test
	public void test02() {
		final List<String> tickets = new ArrayList<String>();
		for (int i = 0; i < 100000; i++) {
			tickets.add("火车票" + i);
		}
		// 退票
		Thread returnThread = new Thread() {
			public void run() {
				while (true) {
					tickets.add("车票" + new Random().nextInt());
				}
			}
		};

		// 售票
		Thread saleThread = new Thread() {

			@Override
			public void run() {
				for (String ticket : tickets) {
					tickets.remove(ticket);
				}
			}
		};

		returnThread.start();
		saleThread.start();
	}
}
