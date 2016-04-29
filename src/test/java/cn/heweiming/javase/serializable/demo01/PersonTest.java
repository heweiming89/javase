package cn.heweiming.javase.serializable.demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testOutStream() {
		ObjectOutputStream outStream = null;
		try {
			outStream = new ObjectOutputStream(new FileOutputStream(
					"f:/person.txt"));
			for (int i = 1; i <= 10; i++) {
				Person person = new Person();
				person.setAge(i);
				person.setName("person" + i);
				outStream.writeObject(person);
			}
			outStream.writeObject(null);
			outStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInStream() {
		try {
			ObjectInput inStream = new ObjectInputStream(new FileInputStream(
					"f:/person.txt"));
			Person person = null;
			// Object object = inStream.readObject();
			// System.out.println(object);
			while ((person = (Person) inStream.readObject()) != null) {
				System.out.println(person);
			}
			inStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
