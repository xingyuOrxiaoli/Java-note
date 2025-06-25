package reflect.code;

import java.lang.reflect.InvocationTargetException;

public class StringReflectObject {

    public StringReflectObject() {
        System.out.println("执行StringReflectObject的无参构造方法");
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className  = "reflect.code.StringReflectObject";
        Class classNameObject = Class.forName(className);

        Object newInstance = classNameObject.getConstructor().newInstance();

    }
}
