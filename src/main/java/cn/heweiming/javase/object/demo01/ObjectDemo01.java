package cn.heweiming.javase.object.demo01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

import cn.heweiming.javase.object.demo01.Person.Home;
import cn.heweiming.javase.util.ObjectUtils;

public class ObjectDemo01 {

	@Test
	public void test01() {
		List<Object> l1 = new ArrayList<Object>();
		List<Object> l2 = new ArrayList<Object>() {

			private static final long serialVersionUID = 1L;
		};
		List<Object> l3 = new ArrayList<Object>() {
			private static final long serialVersionUID = 1L;

			{
			}
		};
		System.out.println(l1.getClass());
		System.out.println(l2.getClass());
		System.out.println(l3.getClass());
	}

	@Test
	public void testClone() throws IOException, ClassNotFoundException {
		Person person = new Person("张三");
		person.setHome(new Person.Home("上海", "123456"));
		Person cloneP1 = ObjectUtils.clone(person);
		Person cloneP2 = ObjectUtils.clone(person);
		cloneP1.setHome(new Person.Home("北京", "5424343"));
		System.out.println(cloneP1);
		System.out.println(cloneP2);

		int[] array = new int[8];
		
		System.out.println(Arrays.toString(array));
	}

}
