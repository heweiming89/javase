package cn.heweiming.javase.collection.demo01;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapSet01 {

	@Test
	public void test01() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "aa");
		map.put(1, "bb");
		map.put(2, "cc");
		map.put(3, "dd");
		System.out.println(map.values().getClass());
	}

	@Test
	public void test02() {
		Map<String, String> map = new HashMap<String, String>();
		final Runtime rt = Runtime.getRuntime();
		rt.addShutdownHook(new Thread() {
			@Override
			public void run() {
				StringBuffer sb = new StringBuffer();
				long heapMaxSize = rt.maxMemory() >> 20;
				sb.append("最大可用内存: " + heapMaxSize + "M\n");
				long total = rt.totalMemory() >> 20;
				sb.append("堆内存大小：" + total + "M\n");
				long free = rt.freeMemory() >> 20;
				sb.append("空闲内存: " + free + "M");
				System.out.println(sb);
			}
		});
		for (int i = 0; i < 393217; i++) {
			map.put("key" + i, "value" + i);
		}

	}

}
