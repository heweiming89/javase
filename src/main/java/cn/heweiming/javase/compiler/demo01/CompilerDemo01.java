package cn.heweiming.javase.compiler.demo01;

import java.net.URI;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.Test;

public class CompilerDemo01 {

	@Test
	public void testCompiler() {
		// Java 源代码
		String sourceStr = "public class Person {" + "private String name;"
				+ "private int age;" + "public String sayHello() {"
				+ "return \"hello\" + name + \"\t\" + age;" + "}";
		String className = "Person";
		String methodName = "sayHello";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager javaFileManager = compiler.getStandardFileManager(null,
				null, null);
		// JavaFileObject javaFileObject = new
		// StringJavaObject(className,sourceStr);

	}
}

class StringJavaObject extends SimpleJavaFileObject {

	protected StringJavaObject(URI uri, Kind kind) {
		super(uri, kind);
	}

}
