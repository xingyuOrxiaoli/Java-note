package reflect.newObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class newObjectTest1 {

    private Integer id;
    private String name;

    public newObjectTest1() {
    }

    public newObjectTest1(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "newObjectTest1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String className = "reflect.newObject.newObjectTest1";
        Class<?> clazz1 = Class.forName(className);

        // 方式1
        Constructor<?> constructorNoParam = clazz1.getConstructor(); // 无参构造方法
        Object obj1 = constructorNoParam.newInstance();
        System.out.println(obj1);

        // 方式2
        Object obj2 = clazz1.newInstance();
        System.out.println(obj2);


        // 有参的创建对象的方式
        Constructor<?> constructorTwoParam = clazz1.getConstructor(Integer.class, String.class);
        Object o = constructorTwoParam.newInstance(1,"两个参数的构造方法创建对象");
        System.out.println(o);


    }
}
