package cn.heweiming.javase.annotation.demo01;

import java.util.Comparator;

import org.junit.Test;

public class AnnotationDemo01 {

	@FieldMapping()
	private String name;
	
	@Test
	public void test(){
		new Comparator<AnnTest>() {

			@Override
			public int compare(AnnTest o1, AnnTest o2) {
				return 0;
			}
			
		};
	}
	
}
