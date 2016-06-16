package cn.heweiming.javase.io.deom01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.Test;

public class StreamDemo01 {
	
	@Test
	public void testLog(){
		try {
			OutputStream outputStream = new FileOutputStream("./log.txt", true);
			PrintStream printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			System.out.println(String.format("%1$tF %1$tT", new Date()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStream01() throws FileNotFoundException{
		DataInputStream dis = new DataInputStream(new FileInputStream(""));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(""));
		
	}
}
