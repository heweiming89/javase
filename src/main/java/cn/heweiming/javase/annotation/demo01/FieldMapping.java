package cn.heweiming.javase.annotation.demo01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMapping {

	public int index() default -1;

	public int begin() default -1;

	public int end() default -1;

	public int length() default -1;

	public String dataType() default "";

	public String prefix() default "";

	public String sufix() default "";

	public String pattern() default "";

	public boolean format() default false;

}
