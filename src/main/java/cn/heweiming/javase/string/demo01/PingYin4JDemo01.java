package cn.heweiming.javase.string.demo01;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingYin4JDemo01 {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(PingYin4JDemo01.class);

	@Test
	public void test01() {

		String inputString = "规范地方都是! I'm Chinese!";

		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		// format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		// format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

		char[] input = inputString.trim().toCharArray();
		StringBuilder sb = new StringBuilder();

		try {
			for (int i = 0; i < input.length; i++) {
				if (Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i],
							format);
					sb.append(temp[0]);
					sb.append(" ");
				} else
					sb.append(Character.toString(input[i]));
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			logger.error("test01()", e); //$NON-NLS-1$

			e.printStackTrace();
		}
		System.out.println(sb.toString());

		if (logger.isDebugEnabled()) {
			logger.debug("test01() - end"); //$NON-NLS-1$
		}
	}

	@Test
	public void test2() {
		String[] pinyin = null;
		// pinyin = PinyinHelper.toYalePinyinStringArray('重');
		pinyin = PinyinHelper.toHanyuPinyinStringArray('重');
		for (String string : pinyin) {
			System.out.println(string);
		}

	}

	@Test
	public void test3() throws BadHanyuPinyinOutputFormatCombination {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		// 小写
		// format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		// 大写
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		// 无音标
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		// 直接用音标符
		// format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
		// 1-4数字表示音标
		// format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);

		String[] pinyin = PinyinHelper.toHanyuPinyinStringArray('重', format);

		for (String string : pinyin) {
			System.out.println(string);
		}
	}

}
