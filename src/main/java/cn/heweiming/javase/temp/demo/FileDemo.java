package cn.heweiming.javase.temp.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class FileDemo {

	@Test
	public void writeFile() throws IOException {

		Class<?> clazz = null;
		OutputStream ourputStream = new FileOutputStream(
				new File("E:/temp/CREDIT_REQ_2016040801"), true);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(ourputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		String symbol = "\n";
		bufferedWriter.append("11111111111" + symbol);
		bufferedWriter.append("22222222222" + symbol);
		bufferedWriter.flush();
		bufferedWriter.close();
		System.out.println("================");
	}

	@Test
	public void createFile() throws IOException {
		File file = new File("d:/a/b/c.c");
		if (!file.exists()) {
			if (file.getParentFile().mkdirs()) {
				System.out.println("FileDemo.createFile()");
				file.createNewFile();
			}
		}
	}

	@Test
	public void editFilename() {
		String filename = "CREDIT_REQ_2016040809";
		int length = filename.length();
		String str = filename.substring("CREDIT_REQ_20160408".length(), length);
		System.out.println(str);
		int serial = Integer.parseInt(str);
		String name = (serial >= 9) ? serial + 1 + "" : "0" + (serial + 1);
		System.out.println(name);
	}

	@Test
	public void testListFile() throws IOException {
		File file = new File("D:/batch/aa");
		boolean b = file.createNewFile();

		File[] listFiles = file.listFiles();
		System.out.println(b);
	}

}
