package cn.heweiming.javase.util;

import java.util.Arrays;

/**
 * @author heweiming 2016年5月1日 下午2:55:42
 */
public class ArrayUtils {

	public static <T> T[] expandCapacity(T[] datas, int newLen) {
		newLen = newLen < 0 ? 0 : newLen;
		return Arrays.copyOf(datas, newLen);
	}

}
