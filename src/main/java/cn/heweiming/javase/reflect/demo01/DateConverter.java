package cn.heweiming.javase.reflect.demo01;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {

	private String pattern;

	public DateConverter(String pattern) {
		this.pattern = pattern;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T convert(Class<T> type, Object value) {
		System.out.println(type.getName());
		String dateStr = (String) value;
		if (dateStr == null || dateStr.trim().isEmpty()) {
			return null;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return (T) sdf.parse(dateStr.trim());
			} catch (ParseException e) {
				throw new ConversionException("不能转换 "
						+ value.getClass().getName() + " 为 " + type.getName());
			}

		}
	}

}
