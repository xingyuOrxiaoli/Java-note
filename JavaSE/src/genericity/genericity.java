package genericity;

import java.util.List;

public class genericity<E> {

    public static void main(String[] args) {
        String fun = fun("123");
        System.out.println(fun);
    }
    public static  <T> T fun(T obj){
        T t = null;
        System.out.println(obj);
        return obj;
    }

    public static <R> void method_static(){

    }

    public <C>void method1(C c,E e){

    }

    public <A extends Object >void method1(A c){

    }

    public <B>void method2( List<? super Object> list){  // 下限

    }
    public <B>void method3( List<? extends Object> list){  // 上限

    }
}
