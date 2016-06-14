package cn.heweiming.javase.io.deom01;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class FileDemo01 {

	@Test
	public void testFile01() {
		File file = new File("E:/temp/file");
		File[] listFiles = file.listFiles();
		// E:\temp\file\CREDIT_REQ_2016040805
		// E:\temp\file\CREDIT_REQ_2016040806
		// E:\temp\file\CREDIT_REQ_2016040807
		// System.out.println(Arrays.toString(listFiles));

		Comparator<File> comparator = new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				System.out.println("name1\t" + o1.getPath());
				System.out.println("name2\t" + o2.getPath());
				return name1.compareTo(name2);
			}
		};

		Set<File> files = new TreeSet<File>();
		files.addAll(Arrays.asList(listFiles));
		System.out.println(files);

		// if(listFiles != null){
		// for (File f : listFiles) {
		// System.out.println(f.getName());
		// }
		// }

		Set<String> strs = new TreeSet<String>();
		strs.add("01");
		strs.add("02");
		strs.add("03");
		strs.add("04");
		strs.add("10");

		String[] names = new String[strs.size()];
		strs.toArray(names);
		int len = names.length;
		System.out.println(len);
		System.out.println(Arrays.toString(names));
	}

	@Test
	public void test02() {
		// E:\temp\file\CREDIT_REQ_2016040805
		// E:\temp\file\CREDIT_REQ_2016040806
		// E:\temp\file\CREDIT_REQ_2016040807
		File file0 = new File("E:/temp/file/CREDIT_REQ_2016040803");
		File file1 = new File("E:/temp/file/CREDIT_REQ_2016040802");
		File file2 = new File("E:/temp/file/CREDIT_REQ_2016040801");
		File file3 = new File("E:/temp/file/CREDIT_REQ_2016040805");
		File file4 = new File("E:/temp/file/CREDIT_REQ_2016040806");
		File[] files = new File[5];
		files[0] = file0;
		files[1] = file1;
		files[2] = file2;
		files[3] = file3;
		files[4] = file4;
		for (File file : files) {
			System.out.println(file);
		}
		System.out.println("================");
		Arrays.sort(files);
		for (File file : files) {
			System.out.println(file);
		}
	}

}
