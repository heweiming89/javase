package cn.heweiming.javase.file.demo01;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTest {

	@Test
	public void testFile01() throws IOException {
		File file = new File(".");
		File[] files = file.listFiles();
		for (File f : files) { // System.out.println(f.getAbsolutePath());
			System.out.println(f.getCanonicalPath());
		}
	}

	@Test
	public void testFile02() throws IOException {
		File file = new File("E:/temp/CREDIT_REQ_2016040803");
		System.out.println("file.exists()\t" + file.exists());
		String name = file.getName();
		System.out.println(name);
		File processingFile = new File(file.getParent(), name + "_PROCESSING");
		boolean b = false;
		if (processingFile.exists() || processingFile.createNewFile()) {
			b = true;
		}
		System.out.println(b);
	}

	@Test
	public void testFile03() {
		File file = new File("E:/temp/CREDIT_REQ_2016040804");
		File processingFile = new File(file.getParent(), file.getName()
				+ "_PROCESSING");
		file.isDirectory();
		File directory = new File(file.getParent() + File.separator
				+ "PROCESSED");
		directory.mkdir();
		File newFile = new File(directory, file.getName() + "_PROCESSED");
		if (file.renameTo(newFile)) {
			processingFile.delete();
		}

	}

	@Test
	public void testFile04() {
		File file = new File("E:/temp/CREDIT_REQ_2016040801");
		File processingFile = new File(file.getParent(), file.getName()
				+ "_PROCESSING");
		file.isDirectory();
		File directory = new File(file.getParent() + File.separator + "ERROR");
		directory.mkdir();
		File newFile = new File(directory, file.getName() + "_ERROR");
		if (file.renameTo(newFile)) {
			processingFile.delete();
		}
	}
	
	@Test
	public void testGetFilePath() throws IOException{
		File file = new File(".");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		
		
		
	}

}
