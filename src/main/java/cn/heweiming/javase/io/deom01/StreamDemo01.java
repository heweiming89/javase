package cn.heweiming.javase.io.deom01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	public void testStream01() throws IOException{
		DataInputStream din = new DataInputStream(new FileInputStream("./log.txt"));
		int i = -1;
		while( (i = din.readInt())!= -1){
			System.out.println(i);
		}
//		DataOutputStream dout = new DataOutputStream(new FileOutputStream(""));
		
	}
}
