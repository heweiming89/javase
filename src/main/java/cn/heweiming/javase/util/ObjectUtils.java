package cn.heweiming.javase.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectUtils {

	public ObjectUtils() {
		throw new Error("不要实例化我！");
	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		// 拷贝产生的对象
		T cloneObj = null;
		try {
			// 读取对象字节数据
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			// 分配内存空间，写入原始对象，生成新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			// 返回新对象,并做类型转换
			cloneObj = (T) ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cloneObj;
	}

}
