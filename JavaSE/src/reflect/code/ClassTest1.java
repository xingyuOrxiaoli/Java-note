package reflect.code;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class ClassTest1 {
    private Integer id;
    String username;
    protected String password;
    public String name;


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz = Class.forName("reflect.code.ClassTest1");

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());
        System.out.println(Arrays.toString(clazz.getInterfaces()));

        System.out.println(clazz.getModifiers());
        System.out.println(Modifier.toString(clazz.getModifiers()));

        // 成员变量
        Field[] fields = clazz.getFields(); // 只能获取public上的  可以获取上级类的
        System.out.println(Arrays.toString(fields));

        fields = clazz.getDeclaredFields(); // 获取所有的属性 但是不包括上级类的属性
        System.out.println(Arrays.toString(fields));

        Field field = clazz.getField("id"); // 只能获取public上的  可以获取上级类的
        System.out.println(field);


    }
}
