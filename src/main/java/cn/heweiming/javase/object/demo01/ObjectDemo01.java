package cn.heweiming.javase.object.demo01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

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
		Person obj = new Person("张三");
		obj.setHome(new Person.Home("上海", "123456"));
		Person person = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		person = (Person) ois.readObject();
		ois.close();
		Objects
	}

}
