package reflect.generic;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.List;


public class GenericTest1 {


    public void fun1 (Map<Integer,Student> map , List<Student> list,String str){
        System.out.println("fun1");
    }
    public Map<Integer,Student> fun2 (){
        System.out.println("fun2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {

        Class<GenericTest1> clazz = GenericTest1.class;
        Method method1 = clazz.getMethod("fun1", Map.class, List.class, String.class);

        System.out.println("==== 参数不带泛型的 ====");
        Type[] parameterTypes = method1.getParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        System.out.println("==== 参数带泛型的 ====");
        Type[] genericExceptionTypes = method1.getGenericParameterTypes();
        for (Type genericExceptionType : genericExceptionTypes) {
            System.out.println(genericExceptionType);
            if (genericExceptionType instanceof ParameterizedType) {
               // 参数化类型
                Type[] actualTypeArguments = ((ParameterizedType) genericExceptionType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("\t" +actualTypeArgument);
                }
            }
            System.out.println("===========================");
        }


        System.out.println("==== 返回值不带泛型的 ====");
        Method method2 = clazz.getMethod("fun2");
        Class<?> returnType = method2.getReturnType();
        System.out.println(returnType);

        System.out.println("==== 返回值带泛型的 ====");
        Type genericReturnType = method2.getGenericReturnType();
        System.out.println(genericReturnType);


        System.out.println("获取数组元素的类型");
        Student[] arr1 = new Student[3];
        int[] arr2 = new int[3];
        System.out.println(arr1.getClass().getComponentType());
        System.out.println(arr2.getClass().getComponentType());
    }
}
