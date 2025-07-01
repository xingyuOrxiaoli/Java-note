package reflect.generic;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GenericTest2 {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // 突破限制
        Class<? extends List> clazz = list.getClass();
        Method method1 = clazz.getMethod("add",Object.class);

        method1.invoke(list,"添加字符串的内容1");
        method1.invoke(list,"添加字符串的内容2");
        System.out.println(list);
    }
}
