package cn.heweiming.javase.script.demo01;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class ScriptDemo01 {

	@Test
	public void testScript() throws ScriptException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
		Bindings bind = engine.createBindings();
		bind.put("factor", 2);
		engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int first = input.nextInt();
			int sec = input.nextInt();
			System.out.println("输入参数是:" + first + "," + sec);
			engine.eval(new InputStreamReader(this.getClass().getClassLoader()
					.getResourceAsStream("script/demo.js")));
			if (engine instanceof Invocable) {
				Invocable in = (Invocable) engine;
				Double result = (Double) in.invokeFunction("formula", first, sec);
				System.out.println("运算结果：" + result.intValue());
			}
		}
		input.close();

	}

	@Test
	public void testGetScript() {
		ScriptEngineManager manager = new ScriptEngineManager();
		// 得到所有的脚本引擎工厂

		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		// 这是Java SE 5 和Java SE 6的新For语句语法
		System.out.println(factories.size());
		for (ScriptEngineFactory factory : factories) {
			// 打印脚本信息

			System.out.printf("Name: %s%n" + "Version: %s%n" + "Language name: %s%n"
					+ "Language version: %s%n" + "Extensions: %s%n" + "Mime types: %s%n"
					+ "Names: %s%n", factory.getEngineName(), factory.getEngineVersion(),
					factory.getLanguageName(), factory.getLanguageVersion(),
					factory.getExtensions(), factory.getMimeTypes(), factory.getNames());
			// 得到当前的脚本引擎

			ScriptEngine engine = factory.getScriptEngine();
		}
	}
}
