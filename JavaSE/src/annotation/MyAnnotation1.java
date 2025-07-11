package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.CLASS)
@Target(value = {ElementType.METHOD , ElementType.TYPE , ElementType.PARAMETER, ElementType.FIELD})
public @interface MyAnnotation1 {

    int id() default 0;

    String[] value() default {};

}
