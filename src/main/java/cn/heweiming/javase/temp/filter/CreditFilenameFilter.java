package cn.heweiming.javase.temp.filter;

import java.io.File;
import java.io.FilenameFilter;

public class CreditFilenameFilter implements FilenameFilter {

	private String prefix;
	private String suffix;

	private CreditFilenameFilter() {

	}

	public CreditFilenameFilter(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File dir, String name) {

		boolean flag = false;
		if (name.startsWith(prefix)) {
			if (suffix != null && !name.endsWith(suffix)) {
				File file = new File(dir.getAbsoluteFile(), name
						+ "_PROCESSING");
				flag = file.exists() ? false : true;
			}
		}
		return flag;
	}

}
