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

	protected Object convertToDate(Class type, Object value, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (value instanceof String) {
			try {
				if (value.toString().isEmpty()) {
					return null;
				}
				Date date = sdf.parse((String) value);
				if (type.equals(Timestamp.class)) {
					return new Timestamp(date.getTime());
				}
				return date;
			} catch (Exception pe) {
				return null;
			}
		} else if (value instanceof Date) {
			return value;
		}

		throw new ConversionException("不能转换 " + value.getClass().getName()
				+ " 为 " + type.getName());
	}

	protected Object convertToString(Class type, Object value) {
		if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			if (value instanceof Timestamp) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}

			try {
				return sdf.format(value);
			} catch (Exception e) {
				throw new ConversionException("日期转换为字符串时出错！");
			}
		} else {
			return value.toString();
		}
	}
}
