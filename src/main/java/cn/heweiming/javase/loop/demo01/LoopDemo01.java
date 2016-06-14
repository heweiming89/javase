package cn.heweiming.javase.loop.demo01;

import org.junit.Test;

public class LoopDemo01 {

	@Test
	public void test01() {
		out: for (int i = 1; i <= 10; i++) {
			System.out.println(" i " + i + "*******");
			for (int j = 1; j <= 10; j++) {
				System.out.print(" j " + j);
				if (j == 5) {
					break out;
				}
			}
			System.out.println("");
		}
	}

}
