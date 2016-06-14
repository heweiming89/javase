package cn.heweiming.javase.file.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
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
		File processingFile = new File(file.getParent(), file.getName() + "_PROCESSING");
		file.isDirectory();
		File directory = new File(file.getParent() + File.separator + "PROCESSED");
		directory.mkdir();
		File newFile = new File(directory, file.getName() + "_PROCESSED");
		if (file.renameTo(newFile)) {
			processingFile.delete();
		}

	}

	@Test
	public void testFile04() {
		File file = new File("E:/temp/CREDIT_REQ_2016040801");
		File processingFile = new File(file.getParent(), file.getName() + "_PROCESSING");
		file.isDirectory();
		File directory = new File(file.getParent() + File.separator + "ERROR");
		directory.mkdir();
		File newFile = new File(directory, file.getName() + "_ERROR");
		if (file.renameTo(newFile)) {
			processingFile.delete();
		}
	}

	@Test
	public void testGetFilePath() throws IOException {
		File file = new File(".");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
	}

	public static void main(String[] args) throws Exception {
		File file = new File("E:/a.txt"); // 100M
		long start = System.currentTimeMillis();
		String lastLine = readLastLine(file, "gbk");
		long delt = System.currentTimeMillis() - start;
		System.out.println(lastLine);
		System.out.println("读取时间(毫秒):" + delt);

		file = new File("E:/b.txt");// 仅一行文字
		start = System.currentTimeMillis();
		lastLine = readLastLine(file, "gbk");
		delt = System.currentTimeMillis() - start;
		System.out.println(lastLine);
		System.out.println("读取时间(毫秒):" + delt);
	}

	public static String readLastLine(File file, String charset) throws IOException {
		if (!file.exists() || file.isDirectory() || !file.canRead()) {
			return null;
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");
			long len = raf.length();
			if (len == 0L) {
				return "";
			} else {
				long pos = len - 1;
				while (pos > 0) {
					pos--;
					raf.seek(pos);
					if (raf.readByte() == '\n') {
						break;
					}
				}
				if (pos == 0) {
					raf.seek(0);
				}
				byte[] bytes = new byte[(int) (len - pos)];
				raf.read(bytes);
				if (charset == null) {
					return new String(bytes);
				} else {
					return new String(bytes, charset);
				}
			}
		} catch (FileNotFoundException e) {
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (Exception e2) {
				}
			}
		}
		return null;
	}

	@Test
	public void test02() {
		// Path path = new P;
		// Files.readAllLines(path );

	}

	@Test
	public void test03() {
		String lineSep = System.getProperty("line.separator");
		System.out.println(lineSep + "fdsafsd");

	}

	@Test
	public void test04() {
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for (String name : charsets.keySet()) {
			System.out.println(name + "\t" + charsets.get(name));
		}
	}

	@Test
	public void test05() {
		char ch = 0;
		System.out.println(ch + "fdsasfsd");
	}

	@Test
	public void test06() {
		try {
			FileInputStream fis = new FileInputStream(
					"D:/openSource/plugins/Properties Editor/Properties Editor.rar");
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry entry = zis.getNextEntry();
			System.out.println(entry);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testZipOut() {
		try {
			FileOutputStream fos = new FileOutputStream("d:/CodeTest/out1.zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			ZipEntry ze1 = new ZipEntry("AAAA.txt");
			ze1.setComment("fdsfafsdafsaf");
			zos.putNextEntry(ze1);
			zos.write(97);
			zos.write(97);
			zos.write(97);
			zos.write(97);

			ZipEntry ze2 = new ZipEntry("BBBB.txt");
			zos.putNextEntry(ze2);
			zos.write(98);
			zos.write(98);
			zos.write(98);
			zos.write(98);
			zos.write(98);

			zos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("FileTest.testZipOut()");
	}
	@Test
	public void testZipIn(){
		try {
			FileInputStream fis = new FileInputStream("d:/CodeTest/out1.zip");
			ZipFile zf = new ZipFile("d:/CodeTest/out1.zip");
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = null;
			while((ze = zis.getNextEntry())!= null){
				InputStream inputStream = zf.getInputStream(ze);
				System.out.println(IOUtils.toString(inputStream));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
