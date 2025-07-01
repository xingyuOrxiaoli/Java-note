# 关于Java中反射的使用

[使用字符串路径进行创建对象及其Class类对象的基础信息和基础使用.java](code%2FStringReflectObject.java)


- Class  类
  - [获取三种方式Class的方式.java](code%2FClassTest1.java)
    - 类名.class
    - Class.forName()
    - 对象.getClass()
- Field 操作
  - [反射直接操作属性.java](FieldsTest.java)
- Method 类 
  - [反射操作方法.java](MethodTest1.java)
- Create Object
  - [newObjectTest1.java](newObject%2FnewObjectTest1.java)
- 反射操作泛型 
  - 参数化类型 List<T>  
  - 类型变量   T
  - 数组类型  带泛型的数组
  - 泛型表达式类型(通配符类型)
  - [存放代码包的位置](generic)
  - [反射操作泛型案例代码.java](generic%2FGenericTest1.java)
  - [通过反射突破泛型的限制.java](generic%2FGenericTest2.java)


## 反射读取注解

[反射读取注解案例代码包的位置](getAnnotation)

[实体类.java](getAnnotation%2FStudent.java)

[反射如何读取实体类中的注解.java](getAnnotation%2FTestGetAnnotationByReflect.java)














