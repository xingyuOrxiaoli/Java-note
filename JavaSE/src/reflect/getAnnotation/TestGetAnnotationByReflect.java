package reflect.getAnnotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestGetAnnotationByReflect {

    public static void main(String[] args) throws NoSuchFieldException {

        Class<Student> clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("===========================================");
        MyTable annotation = clazz.getAnnotation(MyTable.class);
        System.out.println(annotation);
        System.out.println(annotation.name());

        System.out.println("======"+"读取属性的注解"+"======");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
            Annotation[] annotations1 = field.getAnnotations();
            for (Annotation annotation1 : annotations1) {
                System.out.println("\t" + annotation1);
            }
        }

        System.out.println("======"+"读取指定属性的注解"+"======");
        Field username = clazz.getDeclaredField("username");
        MyColumn annotation1 = username.getAnnotation(MyColumn.class);
        System.out.println(annotation1);
        System.out.println(annotation1.name());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
        System.out.println(annotation1.precision());


    }

}
