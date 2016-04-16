package cn.heweiming.javase.reflect.demo01;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

public class ReflectDemo {

	// private String name;
	// private Character sex;
	// private Integer age;
	// private Double income;
	// private Date birthday;
	//
	//

	@Test
	public void testReflect01() throws IntrospectionException {

		String dataStr = "曾阿牛|男|27|1200.7200|1720-02-07";

		Map<Integer, Map<String, Object>> mapping = new HashMap<Integer, Map<String, Object>>();
		Map<String, Object> nameMapping = new HashMap<String, Object>();
		nameMapping.put("name", null);
		Map<String, Object> sexMapping = new HashMap<String, Object>();
		sexMapping.put("sex", null);
		Map<String, Object> ageMapping = new HashMap<String, Object>();
		sexMapping.put("age", null);
		Map<String, Object> incomeMapping = new HashMap<String, Object>();
		incomeMapping.put("income", null);
		Map<String, Object> birthdayMapping = new HashMap<String, Object>();
		birthdayMapping.put("birthday", null);

		mapping.put(0, nameMapping);
		mapping.put(1, sexMapping);
		mapping.put(2, ageMapping);
		mapping.put(3, incomeMapping);
		mapping.put(4, birthdayMapping);

		Person person = new Person();
		PropertyDescriptor propDesc = new PropertyDescriptor("name",
				Person.class);
		Class<Person> clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}

	}

	@Test
	@SuppressWarnings("unchecked")
	public void testReflect02() throws IllegalArgumentException,
			IllegalAccessException, InstantiationException,
			InvocationTargetException, ParseException {
		List<Map<?, Object>> mapping = txtToBeanMapping(Person.class);
		Map<Integer, Object> objMap = (Map<Integer, Object>) mapping.get(0);
		Map<String, Object> fieldMap = (Map<String, Object>) mapping.get(1);
		// 1720-02-07
		String dataStr = "曾阿牛|男|27|1200.7200|";
		String[] fields = dataStr.split("\\|");
		System.out.println(fields.length);
		for (int i = 0; i < fields.length; i++) {
			Object key = objMap.get(i);
			String field = fields[i];
			System.out.println("field\t" + field);
			System.out.println(!field.trim().isEmpty());
			if (!field.trim().isEmpty()) {
				Object value = field.trim();
				// if (i == 4) {
				// SimpleDateFormat sdf = new SimpleDateFormat();
				// sdf.applyPattern("yyyy-MM-dd");
				// Date date = sdf.parse((String) value);
				// value = date;
				// System.out.println(value);
				// }
				fieldMap.put((String) key, value);
			}
			System.out.println(i);
		}
		System.out.println(fieldMap);
		Person person = new Person();
		ConvertUtils.register(new DateConverter("yyyy-MM-dd"),
				java.util.Date.class);
		BeanUtils.populate(person, fieldMap);
		System.out.println(person);
	}

	public List<Map<?, Object>> txtToBeanMapping(Class<?> clazz)
			throws InstantiationException, IllegalAccessException {
		List<Map<?, Object>> list = new ArrayList<Map<?, Object>>();
		Object obj = clazz.newInstance();
		Map<Integer, Object> objMap = new HashMap<Integer, Object>();
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			FieldIndex annotation = field.getAnnotation(FieldIndex.class);
			if (annotation != null) {
				int index = annotation.index();
				String fieldName = field.getName();
				Object fieldValue = field.get(obj);
				objMap.put(index, fieldName);
				fieldMap.put(fieldName, fieldValue);
			}
		}
		list.add(objMap);
		list.add(fieldMap);
		return list;
	}

	@Test
	public void getList() throws InstantiationException, IllegalAccessException {
		List<Map<?, Object>> list = txtToBeanMapping(Person.class);
		for (Map<?, Object> map : list) {
			System.out.println(map);
		}

	}

}
