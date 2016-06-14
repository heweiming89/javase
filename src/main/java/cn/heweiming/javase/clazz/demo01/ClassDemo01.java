package cn.heweiming.javase.clazz.demo01;

import org.junit.Test;

public class ClassDemo01 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	public void test01() {
		Class<?> c1 = ClassDemo01.class;
		Class<?> c2 = ClassDemo01.class;
		System.out.println(c1 == c2);
	}

}
