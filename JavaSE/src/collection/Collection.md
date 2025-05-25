# Java中的集合介绍


## Set集合

  **特点： 无序，唯一(不重复,和equal函数有关)**

### HashSet

- 采用Hashtable哈希表存储结构
- 优点: 添加速度快、查询速度快、删除速度快
- 缺点: 无序

[HashSet以上特性体现的代码](HashSetTest.java)

对于自定义类的唯一性，需要重写 **equals 和 hashCode两个方法 缺一不可**

[HashSet存储自定义类相关代码](HashSetAboutStudent.java)



### LinkedHashSet

- 采用哈希表存储结构，同时使用链表维护次序
- 有序(添加顺序)

[LinkedHashSet以上特性体现的代码](LinkedHashSetTest.java)

对于自定义类的唯一性，需要重写 **equals 和 hashCode两个方法 缺一不可** 。 这部分和HashSet一样

[LinkedHashSet存储自定义类相关代码](LinkedHashSetAboutStudent.java)

### TreeSet

- 采用二叉树(红黑树)的存储结构
- 优点: 有序、查询速度比List快(按内容查询)
- 缺点: 查询速度没有HashSet快

[TreeSet以上特性体现的代码](TreeSetTest.java)

- 对于自定义类  **必须实现Comparable接口并重写compareTo方法**，否则会抛出异常
- 可以不重写 equals和 hashCode 因为这个的唯一和有序是借助 compareTo方法
- compareTo方法每次添加元素进行调用，如果添加第一个元素是自己和自己比。

- 也可以定义外部外部比较类，优先使用外部比较类
[TreeSet存储自定义类相关代码](TreeSetAboutStudent.java)



## Hash 哈希表的结构和特点

hashtable 也叫散列表
- 特点：快 
- 结构有很多种
  - 顺序表+链表 (常用的方式)
- 主结构: 顺序表
- 哈希函数的选择
  - 直接定址法
  - 平方取中法
  - 折叠法
  - 除留取余法
- 处理冲突的方法
  - 链地址
  - 开放地址法
  - 再散列法
  - 建立一个公共的溢出区


## Map集合

特点 :Key-value对 

### HashMap

- 采用Hashtable 哈希表存储结构
- 优点: 添加速度快、查询速度快、删除速度快
- 缺点: key无序
- key可以为null
- 需要重写equals和hashCode方法

[HashMapTest相关代码](map%2FHashMapTest.java)

#### HashMap相关源码介绍

- JDK7之前，HashMap底层是一个table数组+链表实现的哈希表存储结构
  - Entry 实现Map.Entry<K,V>
    - final K key 属性   key值
    - V value 属性       key对应的value
    - final int hash属性 key对应的哈希码
    - next 属性   指向下一个节点的引用
  - HashMap中的常量解释
    - DEFAULT_INITIAL_CAPACITY 默认的初始化容量 16
    - MAXIMUM_CAPACITY  最大容量  1 << 30
    - DEFAULT_LOAD_FACTOR 默认的加载因子  0.75
    - size  哈希表中有多少个节点
    - threshold 阈值 初始容量 * 加载因子  添加元素出现碰撞如果节点大于这个阈值则会扩容
    - modCount 关于多线程处理的。哈希表结构被修改的次数。结构性修改是指那些改变 HashMap 中映射数量或以其他方式修改其内部结构的操作（例如重新散列）此字段用于使 HashMap 的 Collection 视图上的迭代器快速失败。
  - Entry数组

- JDK8之后, HashMap shou
  - Node数组
  - HashMap中的常量解释
    - DEFAULT_INITIAL_CAPACITY 默认的初始化容量 16
    - MAXIMUM_CAPACITY  最大容量  1 << 30
    - DEFAULT_LOAD_FACTOR 默认的加载因子  0.75
    - TREEIFY_THRESHOLD(新增的常量) 变为红黑树的长度阈值 8
    - UNTREEIFY_THRESHOLD(新增的常量) 红黑树降为链表的阈值 6
    - 

### LinkedHashMap

- 采用哈希表存储结构 ，同时使用链表维护次序
- key有序(添加顺序)
- key可以为null
- 需要重写equals和hashCode方法

[LinkedHashMap相关代码](map%2FLinkedHashMapTest.java)
### TreeMap

- 采用二叉树(红黑树)的存储结构
- 优点: key有序 （比较顺序，自然顺序），查询速度比List快(按内容查询)
- 缺点: 查询速度没有HashSet快
- key不可以为null  因为底层要调用比较方法compareTo，因此不可以为null  因此key为null; 则为空指针异常
- 需要实现Comparable接口

[TreeMap相关代码](map%2FTreeMapTest.java)






