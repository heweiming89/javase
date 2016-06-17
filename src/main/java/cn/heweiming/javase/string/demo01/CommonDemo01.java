package cn.heweiming.javase.string.demo01;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

public class CommonDemo01 {

	@Test
	public void test01() {
		String[] tokens = "中国|美国|英国".split("\\|");
		for (String token : tokens) {
			System.out.println(token);
		}

		// Integer.

		// Integer integer = Integer.valueOf(null);
		// System.out.println(111);
		// System.out.println(integer);

	}

	@Test
	public void test02() {
		// Charset charset = Charset.defaultCharset();
		// System.out.println(charset.name());
		// SortedMap<String, Charset> charsets = Charset.availableCharsets();
		// for (String name : charsets.keySet()) {
		// System.out.println(name + "\t" + charsets.get(name));
		// }

		Charset charset = Charset.forName("UTF-8");
		System.out.println(charset.name());
		System.out.println(charset.aliases());
		ByteBuffer buffer = charset.encode("中国你好");

		// byte[] array = buffer.array();
		// ByteBuffer.wrap(array);
		CharBuffer charBuffer = charset.decode(ByteBuffer.wrap(buffer.array()));
		System.out.println(charBuffer.toString());

	}

	@Test
	public void testEncrypt() {
		String str = "他们最习惯加密储存在硬盘上的文件";
		str = "öÌ⤠@⻏ᲀᗦẈᕸᤈ㙌㣸*㢤⮧Ö";
		char[] charArray = str.toCharArray();
		for (int i = 0, len = charArray.length; i < len; i++) {
			charArray[i] = (char) (charArray[i] ^ 20000);
		}
		System.out.println("加密后的字符串\n" + new String(charArray));

	}

}
