package cn.heweiming.javase.instance.demo01;

import java.util.Date;

import org.junit.Test;

public class InstanceDemo01 {

	@Test
	public void testInstanceOf() {
		// boolean b1 = "string" instanceof Object;
		// boolean b2 = new String() instanceof String;
		// boolean b3 = new Object() instanceof String;
		// boolean b4 = 'A' instanceof Character;
		// boolean b5 = null instanceof String;
		// boolean b6 = (String) null instanceof String;
		// boolean b7 = new Date() instanceof String;
		// boolean b8 = new GenericClass<String>().isDateInstance("");
	}
}

class GenericClass<T> {
	public boolean isDateInstance(T t) {
		return t instanceof Date;
	}
}
