package cn.heweiming.javase.collection.demo01;

import java.text.Collator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class CollectionDemo01 {

	@Test
	public void testSort() {
		List<String> strs = new LinkedList<String>();
		strs.add("一");
		strs.add("二");
		strs.add("三");
		strs.add("五");
		strs.add("四");
		System.out.println(strs);
		Collections.sort(strs);
		System.out.println(strs);
		Collections.sort(strs, Collator.getInstance(Locale.CHINA));
		System.out.println(strs);
	}
}
