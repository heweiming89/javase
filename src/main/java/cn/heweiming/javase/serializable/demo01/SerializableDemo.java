package cn.heweiming.javase.serializable.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class SerializableDemo {

	@Test
	public void test() {
		File file = new File("F:/Serializable1.txt");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			Person person = new Person();
			person.setName("张三");
			person.setAge(22);
			oos.writeObject(person);
			oos.writeObject(null);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadObject() {
		
		File file = new File("F:/Serializable.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Object person = null;
			while ((person = ois.readObject()) != null) {
				System.out.println(person);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
