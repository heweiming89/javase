package cn.heweiming.javase.collection.demo01;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * @author heweiming 2016年5月1日 下午6:30:21
 */
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

	@Test
	public void testSub() {
		// 初始化一个固定长度，不可变列表
		List<Integer> initData = Collections.nCopies(20, 2);
		System.out.println(initData);
		// for (int i = 0, len = initData.size(); i < len; i++) {
		// initData.set(i, i + 1);
		// }
		ArrayList<Integer> list = new ArrayList<Integer>(initData);
		for (int i = 0, len = list.size(); i < len; i++) {
			list.set(i, i + 1);
		}
		System.out.println(list);
		List<Integer> list2 = list.subList(10, 20);
		System.out.println(list2);
		list2.clear();
		System.out.println(list);

	}

	@Test
	public void testSort2() {
		Set<String> strs = new TreeSet<>();
		strs.add("1011605040100000030000");
		strs.add("1011605040100000040000");
		strs.add("1011605040100000050000");
		strs.add("1011605040600000010000");
		strs.add("1011604290600000030000");
		strs.add("1011605040600000020000");
		strs.add("1011605040600000040000");
		strs.add("1011605040600000050000");
		strs.add("1011605040600000060000");
		strs.add("1011605040600000070000");
		strs.add("1011605040600000080000");
		strs.add("1011605040600000090000");
		strs.add("1011605040600000100000");
		strs.add("1011605040600000110000");
		strs.add("1011605040600000120000");
		strs.add("1011605040600000130000");
		strs.add("1011605040700000010000");
		strs.add("1011605040700000030000");
		strs.add("1011605040700000020000");
		strs.add("1011605040700000050000");
		strs.add("1011605040700000070000");
		strs.add("1011605040700000080000");
		strs.add("1011605040700000060000");
		strs.add("1011605040700000100000");
		strs.add("1011605040600000030000");
		strs.add("1011605040700000090000");
		strs.add("1011605040700000110000");
		System.out.println(strs.size());
		int index = 0;
		for (String str : strs) {
			System.out.println((++index) + "\t" + str);
		}
	}

	@Test
	public void testModify() {
		List<Integer> list = new LinkedList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		List<Integer> subList = list.subList(0, 1);
		list.add(44);
		System.out.println(list.size());
		System.out.println(subList.size());
	}

	@Test
	public void testUnModify() {
		List<String> list = new LinkedList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		list = Collections.unmodifiableList(list);
		list.add("444");
	}

	@Test
	public void testList() {
		List<String> list1 = new LinkedList<String>();
		list1.add("aaa");
		list1.add("bbb");
		List<String> list2 = new LinkedList<String>();
		list2.add("bbb");
		list2.add("ccc");
		// 并集
		// list1.addAll(list2);
		// 交集
		// list1.retainAll(list2);
		// 差集
		// list1.removeAll(list2);
		// 无重复的并集
		list2.removeAll(list1);
		list1.addAll(list2);
		System.out.println(list1);
	}

	@Test
	public void testEmpty() {
		Collection<String> strs = Collections.emptyList();
		System.out.println(strs);
	}

	@Test
	public void testListIterator() {
		List<Integer> list = new LinkedList<>();
		long initBegin = System.currentTimeMillis();
		for (int i = 0; i < 5_000_000; i++) {
			list.add(i);
		}
		long initEnd = System.currentTimeMillis();
		System.out.println("初始化数据用时\t" + (initEnd - initBegin));
		long time0 = System.currentTimeMillis();
		for (Integer integer : list) {
			// System.out.println(integer);
		}
		long time1 = System.currentTimeMillis();
		System.out.println("LinkedList foreach\t" + (time1 - time0));
		for (int i = 0, len = list.size(); i < len; i++) {
			// System.out.println(integer);
		}
		long time2 = System.currentTimeMillis();
		System.out.println("LinkedList for\t" + (time2 - time1));
		list = new ArrayList<>(list);
		for (Integer integer : list) {

		}
		long time3 = System.currentTimeMillis();
		System.out.println("ArrayList foreach\t" + (time3 - time2));
		for (int i = 0; i < list.size(); i++) {

		}
		long time4 = System.currentTimeMillis();
		System.out.println("ArrayList for\t" + (time4 - time3));
		for (int i = 0, len = list.size(); i < len; i++) {

		}
		long time5 = System.currentTimeMillis();
		System.out.println("ArrayList for\t" + (time5 - time4));
	}

}
