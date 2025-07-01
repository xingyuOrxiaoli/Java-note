package reflect.code;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class ClassTest1 {
    private Integer id;
    String username;
    protected String password;
    public String name;


    /**
     * 获取Class的方式
     * @param args
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class<ClassTest1> clazz1 = ClassTest1.class;
        Class<?> clazz2 = Class.forName("reflect.code.ClassTest1");
        Class<? extends ClassTest1> clazz3 = new ClassTest1().getClass();


        Class<Integer> intClazz = int.class;
        Class<int[]> arrClazz = int[].class;

        Class<Integer> integerClass = Integer.TYPE; // Integer包装的int的类对象




    }
}
