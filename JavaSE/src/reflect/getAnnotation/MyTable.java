package reflect.getAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 反射读取需要设置运行
@Target(ElementType.TYPE)
public @interface MyTable {
    String name();
}
