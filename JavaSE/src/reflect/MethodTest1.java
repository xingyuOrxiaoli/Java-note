package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest1 {


    public void fun1(){
        System.out.println("fun1");
    }
    public void fun1(String str){
        System.out.println("fun1 one param");
    }
    public String fun2(){
        System.out.println("fun2");
        return "fun2";
    }

    public String fun2(String str){
        System.out.println("fun2 one param");
        return "fun2";
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<MethodTest1> clazz1 = MethodTest1.class;
        MethodTest1 obj = clazz1.newInstance();

        Method methodNoParam = clazz1.getMethod("fun1");
        methodNoParam.invoke(obj);

        Method methodOneParam  = clazz1.getMethod("fun1",String.class);
        methodOneParam.invoke(obj,"无返回值，有参方法");

        Method methodReturnAndOneParam = clazz1.getMethod("fun2",String.class);
        Object res = methodReturnAndOneParam.invoke(obj, "有返回值，有参方法");
        System.out.println("返回值 ： "+res);

    }
}
