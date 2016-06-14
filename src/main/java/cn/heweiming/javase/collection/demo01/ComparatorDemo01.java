package cn.heweiming.javase.collection.demo01;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ComparatorDemo01 {
	
	@Test
	public void test01(){
		List<Integer> list = new LinkedList<Integer>();
		list.add(111);
		list.add(222);
		list.add(333);
		list.add(444);
		Collections.reverse(list);
		System.out.println(list);
		Collections.reverseOrder();
	}
	
	
}
