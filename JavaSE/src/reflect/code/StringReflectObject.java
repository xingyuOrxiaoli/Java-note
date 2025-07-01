package reflect.code;

import java.lang.reflect.*;
import java.util.Arrays;

class SuperClass{
    private String superClassUsername;
    String superClassPassword;
    protected char superClassSex;
    public int superClassSno;
}
public class StringReflectObject extends SuperClass{

    private String username;
    String password;
    protected char sex;
    protected Character sex2;

    public int sno;
    public Integer id;

    public StringReflectObject() {
        System.out.println("执行StringReflectObject的无参构造方法");
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String className  = "reflect.code.StringReflectObject";
        Class classNameObject = Class.forName(className);

        // 基本信息
        System.out.println("==============" +"基本信息"+"==============");
        System.out.println(classNameObject.getName()); // 类地址
        System.out.println(classNameObject.getSimpleName()); // 类名
        System.out.println(classNameObject.getSuperclass()); // 父类地址
        System.out.println(Arrays.toString(classNameObject.getInterfaces())); // 实现的接口地址
        System.out.println(classNameObject.getModifiers());                    // public 对应1
        System.out.println(Modifier.toString(classNameObject.getModifiers())); // 修饰符 public

        // 成员变量
        System.out.println("==============" +"成员变量"+"==============");
        Field[] fields = classNameObject.getFields();
        for (Field field : fields) {
            System.out.println(field); // 只能打印出 public修饰符的
        }
        System.out.println("==============" +"获取成员变量不同修饰符的获取方法的范围"+"==============");

        Field sno = classNameObject.getField("sno"); //只能 public
        System.out.println(sno);
        Field username = classNameObject.getDeclaredField("username");// public protected default private
        System.out.println(username);

        Field superClassSno = classNameObject.getSuperclass().getField("superClassSno"); // 只能 public
        System.out.println(superClassSno);
        Field superClassUsername = classNameObject.getSuperclass().getDeclaredField("superClassUsername"); // public protected default private
        System.out.println(superClassUsername);

        System.out.println("==============" +"成员方法对象基本信息"+"==============");
        System.out.println(sno.getName() +"\t" +Modifier.toString(sno.getModifiers()) +"\t" + sno.getType());

        System.out.println("==============" +"获取public成员方法"+"==============");
        Method[] methods = classNameObject.getMethods();
        for (Method method : methods) {
            System.out.println(method); // 只有公共的
        }
        System.out.println("==============" +"获取所有的成员方法"+"==============");
        Method[] declaredMethods = classNameObject.getDeclaredMethods(); // 所有的 包含父类的
        for (Method method : declaredMethods) {
            System.out.println(
                    method.getName() +"\t"
                            + method.getModifiers() +"\t"
                            + Modifier.toString(method.getModifiers()) +"\t"
                            + method.getReturnType().getName() + "\t"
                            + Arrays.toString(method.getParameterTypes())
            );
        }

        System.out.println("==============" +"获取指定的成员方法"+"==============");
        Method fun1 = classNameObject.getDeclaredMethod("fun1", String.class, String.class); // 不包含父类
        System.out.println(
                fun1.getName() +"\t"
                        + fun1.getModifiers() +"\t"
                        + Modifier.toString(fun1.getModifiers()) +"\t"
                        + fun1.getReturnType().getName() + "\t"
                        + Arrays.toString(fun1.getParameterTypes())
        );
        System.out.println("==============" +"获取构造方法"+"==============");
        Constructor[] constructors = classNameObject.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("==============" +"获取所有构造方法"+"==============");
        Constructor[] declaredConstructors = classNameObject.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor);
        }
        System.out.println("==============" +"获取指定构造方法"+"==============");
        Constructor constructor = classNameObject.getConstructor(); // 默认为无参 参数是一个可变参数
        System.out.println(constructor);





        Object newInstance = classNameObject.getConstructor().newInstance();

    }
    private void fun1(String param1 , String param2){}

    private void fun2(String param1 , String ...param2){}

    private void fun3(){}
    public void fun4(){}


}
