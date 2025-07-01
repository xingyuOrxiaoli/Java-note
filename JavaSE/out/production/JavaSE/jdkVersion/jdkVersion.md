# 关于Java中JDK版本的不同

## JDK8
- Lamda表达式
  - 要求接口是函数式接口(接口中只有一个抽象方法) 
  - 可以使用函数注解用于检验  @FunctionalInterface
  - 可以有多个非抽象的方法
  - [Lamda表达式使用案例相关代码.java](jdk8%2FLamdaTest1.java)
  - 四种函数式接口
    - 消费型接口 Consumer  有参数没有返回值  foreach()函数
    - 共给型接口           只有返回值没有参数  
    - 函数型接口           一个输入参数一个输出参数
    - 断言型接口 Predicate 输入一个参数，返回一个boolean返回值   
- Stream API
  - 对集合、容器对象操作进行操的API， 提高变成编程效率
  - 函数式语言 + 多和时代综合影响的产物
  - [Stream API相关使用代码.java](jdk8%2FStreamTest.java)
- 函数式接口
- 新的日期类
  - Instant 代表的是时间戳
  - LocalDate 代表时间 xxxx-xx-xx
  - LocalTime 表示时刻 xx:xx:xx.xxx
  - ZonedDateTime 表示一个包含时区的完整日期时间，偏移量是以UCT格林日期为准
  - Period 时间段
  - ZoneOffset 代表时区偏差量，比如 +8:00
  - Clock  表示时钟 ，比如获取目前美国纽约的时间
  - [新的日期类简单使用的代码.java](jdk8%2FNewDateTimeTest.java)


## JDK7
- 支持钻石表达式 such as: new ArrayList<>()



# JDK9 

- 最大的改变  **模块化系统**
  - 某一模块运行的时，JVM只会启动和它有依赖的模块，不会加载所有的模块到内存中，这样大大提高了性能
  - 模块化可以理解成 在package包外面再加一层 成员的作用范围在当前包和当前项目之间有增加了一层 ： 模块
- String 底层数组从char[] 变成 byte[]  节省空间
  - 节省空间 同时通过一个**coder成员变量（这是一个byte变量 0 使用一个字节表示  1的时候需要两个字节表示）**作为编码格式的标识，使用LATIN1还是UTF-16,这个实在String生成的时候自动的，
  - 如果字符串都是能用LATIN1就能标识的时候就是 0 否则就是UTF-16
- 接口中可以定义private的非抽象方法
  - [InterfaceTest.java](jdk9%2FInterfaceTest.java)


# JDK10
- var变量 局部变量类型的推断
- [var类型的使用代码.java](jdk10%2FVarTest.java)
- 只限制与方法里面的局部推断  成员变量不能使用



# JDK11
- 引入两种新的垃圾收集器
  - 跨时代的 ZGC
  - Epsilon  垃圾回收器 ，但是回收工作不执行
    - 一种完全消极的GC ，只有Java的堆资源被耗尽，JVM直接关闭
    - 配置 -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
  - ZGC
    - JDK11最瞩目的特性
    - 配置 -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
  - GC在清理垃圾的时候，其余所有线程都要停下来，这样GC才可以真的工作，以免造成混乱，这个过程叫做STW。STW越长，就越影响应用的响应时间。这个停顿无法避免。


# JDK12
- switch 语句的变化：不再使用break 关键字。使用case L -> 表示如果标签匹配，则只执行标签右侧的代码
- 该功能在JDK12 13中只是预览功能 最后在JDK14 中被确认为最终功能





















