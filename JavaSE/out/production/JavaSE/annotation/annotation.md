# 关于Java中注解的使用


- 内置注解
  - @Override         检查是否为方法重载
  - @Deprecated      标记方法过时
  - @SuppressWarnings 压制警告
    - deprecation : 使用过时的方法类或方法警告
    - unchecked   : 执行了未检查的转换时警告，如使用集合时未指定泛型
    - fallthrough : 当在switch语句使用时发生case穿透
    - path :在类路径，源文件路径等中有不存在的路径警告
    - serial : 当在可序列化的类上缺少serialVersionUID定义时的警告
    - finally : 任何finally字句不能完成时的警告
    - all : 关于以上所有情况的警告
- JDK7之后新增支持注解
  - @SafeVarargs - Java7开始支持 ，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告
  - @FunctionalInterface - JDK8开始支持 ，标识一个匿名函数或函数式接口
  - @Repeatable  - Java8开始支持，标识某注解可以在同一声明上使用多次


- 元注解 JDK5 支持四个元注解
  - @Retention  注解的生命周期  默认为RetentionPolicy.CLASS
    - SOURCE : 源代码级别，注解将被编译器丢弃(该类型的注解信息只会保留在源码里，源码经过编译后，直接信息会被丢弃，不会保留在编译好的class文件里面吗)
    - CLASS  : 注解在class文件中可用,但会被VM丢弃(该类型的注解信息会保留在源码里和class文件里，执行的时候，不会加载到虚拟机中)
    - RUNTIME: 注解信息将在运行期(JVM)也保留,因此可以通过反射机制读取注解的信息(源码、class文件和执行的时候都有注解的信息)如：SpringMVC中的@Controller等等
  - @Target 注解应用的位置  默认可以使用到任何地方
    - ElementType 枚举类型下的，value是一个数组
  - @Documented 标记这些注解是否包含在用户文档中
  - @Inherited  注解被主动继承，如果在注解类型声明中存在该元注解，并且用户在某一个类声明中查询该注解类型，同时该注解类声明中没有此类型的注解，则将在该类的父类中自动查询该注解的类型



[自定义的注解.java](MyAnnotation1.java)


[自定义注解使用案例.java](Test1.java)

