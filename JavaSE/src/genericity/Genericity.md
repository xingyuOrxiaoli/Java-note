# 关于Java中泛型的使用


## 泛型方法

不是泛型类中用到的泛型的方法就是泛型方法，而是指将泛型在方法上定义
- add(E e) 不是
- E get()  不是
- 下面的是  [运行代码](genericity.java)
```java
    public static void main(String[] args) {
        String fun = fun("123");
        System.out.println(fun);
    }   
    
    // 加到返回值前面
    public static  <T> T fun(T obj){
        T t = null;
        System.out.println(obj);
        return obj;
    }
```
- 泛型接口
- 泛型类
- 静态方法使用泛型的方法
- 泛型的限制  
  - 上限 extends
  - 下限 super

**泛型只作用与代码编译阶段**





