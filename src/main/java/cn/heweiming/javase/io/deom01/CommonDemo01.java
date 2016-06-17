package cn.heweiming.javase.io.deom01;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.junit.Test;

public class CommonDemo01 {

	@Test
	public void testCommon01() {
		String str = System.getProperty("user.dir");
		System.out.println(str);
	}

	@Test
	public void testTypeWrite() throws IOException {
		String lineSep = System.getProperty("line.separator");
		DataOutputStream dout = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("F:/test/test01.txt")));
		dout.writeInt(100);
		dout.writeUTF(lineSep);
		dout.writeLong(100);
		dout.writeLong(100);
		dout.close();
		System.out.println("测试结束");

	}

	@Test
	public void testRandom() throws IOException {
		RandomAccessFile in = new RandomAccessFile("F:/test/test01.txt", "rw");
		long length = in.length();
		// in.write
		System.out.println(length);

	}

	@Test
	public void testNio() {
		try {
			Path path = Paths.get("test", "test1");
			String string = path.toString();
			System.out.println(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testPath() {
		Path basePath = Paths.get(System.getProperty("user.dir"), "src");
		Path path = Paths.get("src", "main", "resources");
		// System.out.println((basePath.resolve(path.toString())).toString());
		System.out.println((basePath.resolveSibling(path.toString())).toString());
	}

	@Test
	public void testFiles() throws IOException {
		Path path = Paths.get("log.txt");
		byte[] bytes = Files.readAllBytes(path);
		System.out.println(Files.exists(path));
		String content = new String(bytes);
		System.out.println(content);
	}

	@Test
	public void testFiles2() throws IOException {
		// StandardOpenOption
		List<String> lines = Files.readAllLines(Paths.get("log.txt"),
				Charset.defaultCharset());
		for (String line : lines) {
			System.out.println(line);
		}
		Files.write(Paths.get("log.txt"), lines, Charset.defaultCharset(), StandardOpenOption.APPEND);
	}
	
	@Test
	public void testFile3() throws IOException{
		Path path = Paths.get("log.txt");
		Charset charset = Charset.defaultCharset();
		InputStream inputStream = Files.newInputStream(path);
		OutputStream outputStream = Files.newOutputStream(path);
		BufferedReader bufferedReader = Files.newBufferedReader(path, charset);
		BufferedWriter bufferedWriter = Files.newBufferedWriter(path, charset);
	}

}
