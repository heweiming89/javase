package cn.heweiming.javase.temp.demo;

import java.util.Objects;

import org.junit.Test;

public class ObjectsDemo {

	@Test
	public void test1() {
		String a = "hello";
		String b = "hello";
		int i = Objects.hash(a);
		int j = Objects.hash(b);
		System.out.println(a + "\t" + i);
		System.out.println(b + "\t" + j);
		String str = null;
		Objects.requireNonNull(str, "该数据内容为空");

	}

}
