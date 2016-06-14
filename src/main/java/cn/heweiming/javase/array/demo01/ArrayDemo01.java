/**
 * 
 */
package cn.heweiming.javase.array.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;

/**
 * @author heweiming 2016年5月1日
 */
public class ArrayDemo01 {

	class Balloon {

		private int id;

		private Color color;

		public Balloon() {

		}

		public Balloon(int id, Color color) {
			this.id = id;
			this.color = color;
		}

		public Color getColor() {
			return color;
		}

		public int getId() {
			return id;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Balloon [id=" + id + ", color=" + color + "]";
		}

	}

	enum Color {
		RED, ORANGE, YELLOW, GREEN, INDIGO, BLUE, VIOLET;

		@Override
		public String toString() {
			return RED.name();
		}

	}

	@Test
	public void testDeepCopy() {
		int balloonCount = 7;
		Balloon[] box1 = new Balloon[balloonCount];
		for (int i = 0; i < balloonCount; i++) {
			box1[i] = new Balloon(i, Color.values()[i]);
		}
		System.out.println(Arrays.toString(box1));
		Balloon[] box2 = Arrays.copyOf(box1, box1.length);
		box2[6].setColor(Color.BLUE);
		System.out.println(Arrays.toString(box1));

	}

	@Test
	public void testCopy() {
		int[] src = new int[10];
		Arrays.fill(src, 72);
		System.out.println(Arrays.toString(src));
		int[] dest = new int[20];
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.println(Arrays.toString(dest));
	}

	@Test
	public void testSort() {
		int[] numbers = new int[10];
		for (int i = 0, len = numbers.length; i < len; i++) {
			numbers[i] = (int) (Math.random() * 10);
		}
		System.out.println(Arrays.toString(numbers));
		int[] clone = numbers.clone();
		Arrays.sort(clone);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(clone));
	}

	@Test
	public void testSort2() {
		Integer[] digits = new Integer[10];
		for (int i = 0, len = digits.length; i < len; i++) {
			digits[i] = (int) (Math.random() * 10);
		}
		System.out.println(Arrays.toString(digits));
		List<Integer> dataList = Arrays.asList(digits);
		TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
		System.out.println(ts.first());
		System.out.println(ts.last());
		System.out.println(ts.floor(ts.first()));
		System.out.println(ts.higher(ts.first()));
		System.out.println(ts.lower(ts.last()));
	}

	@Test
	public void testAsList() {
		int[] data = { 1, 2, 3, 4, 5 };
		String string = Arrays.toString(data);
		System.out.println(string.substring(1).substring(0, string.length() - 2));
		// List<int[]> list = Arrays.asList(data);
		// System.out.println("元素类型：" + list.get(0).getClass());
		// System.out.println("前后是否相等:" + data.equals(list.get(0)));
	}

	@Test
	public void testAVG1() {
		int stuCount = 80 * 10000;
		List<Integer> scores = new ArrayList<Integer>(stuCount);

		for (int i = 0; i < stuCount; i++) {
			scores.add(new Random().nextInt(150));
			// System.out.println(i);
		}
		long start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0, size = scores.size(); i < size; i++) {
			sum += scores.get(i);
		}

		// for (Integer i : scores) {
		// sum += (i != null ? i : 0);
		// }

		System.out.println("平均分是:" + (sum / scores.size()));
		System.out.println("用时:" + (System.currentTimeMillis() - start));
	}

	@Test
	public void testAVG2() {
		int stuCount = 80 * 10000;
		List<Integer> scores = new LinkedList<Integer>();

		for (int i = 0; i < stuCount; i++) {
			scores.add(new Random().nextInt(150));
			// System.out.println(i);
		}
		long start = System.currentTimeMillis();
		int sum = 0;
		// for (int i = 0, size = scores.size(); i < size; i++) {
		// sum += scores.get(i);
		// }

		for (Integer i : scores) {
			sum += (i != null ? i : 0);
		}

		System.out.println("平均分是:" + (sum / scores.size()));
		System.out.println("用时:" + (System.currentTimeMillis() - start));
	}

	@Test
	public void testEquals() {
		ArrayList<String> strs1 = new ArrayList<String>();
		strs1.add("a");
		Vector<String> strs2 = new Vector<String>();
		strs2.add("a");
		System.out.println(strs1.equals(strs2));

	}

}
