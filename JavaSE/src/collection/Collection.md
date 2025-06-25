# Java中的集合基础介绍


## Set集合

  **特点： 无序，唯一(不重复,和equal函数有关)**

### HashSet

- 采用Hashtable哈希表存储结构
- 优点: 添加速度快、查询速度快、删除速度快
- 缺点: 无序

[HashSet以上特性体现的代码](set/HashSetTest.java)

对于自定义类的唯一性，需要重写 **equals 和 hashCode两个方法 缺一不可**

[HashSet存储自定义类相关代码](set/HashSetAboutStudent.java)

#### HashSet源码简单介绍

- 底层是new一个HashMap  ，并且所有的key对应的value是同一个


### LinkedHashSet

- 采用哈希表存储结构，同时使用链表维护次序
- 有序(添加顺序)

[LinkedHashSet以上特性体现的代码](set/LinkedHashSetTest.java)

对于自定义类的唯一性，需要重写 **equals 和 hashCode两个方法 缺一不可** 。 这部分和HashSet一样

[LinkedHashSet存储自定义类相关代码](set/LinkedHashSetAboutStudent.java)

### TreeSet

- 采用二叉树(红黑树)的存储结构
- 优点: 有序、查询速度比List快(按内容查询)
- 缺点: 查询速度没有HashSet快

[TreeSet以上特性体现的代码](set/TreeSetTest.java)

- 对于自定义类  **必须实现Comparable接口并重写compareTo方法**，否则会抛出异常
- 可以不重写 equals和 hashCode 因为这个的唯一和有序是借助 compareTo方法
- compareTo方法每次添加元素进行调用，如果添加第一个元素是自己和自己比。

- 也可以定义外部外部比较类，优先使用外部比较类
[TreeSet存储自定义类相关代码](set/TreeSetAboutStudent.java)

#### TreeSet源码简单介绍

- 底层是new一个TreeMap  ，并且所有的key对应的value是同一个


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

- **扩容为 2 倍**
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

#### TreeMap源码介绍

-  基本特征: 二叉树、二叉查找树、二叉平衡树、红黑树
-  节点结构:
  - key 
  - value  
  - left   左孩子节点
  - right  右孩子节点
  - parent 父节点
  - color  默认为黑色
- 成员变量
  - comparator 外部比较器
  - size  节点数
  - root  指向根节点一个引用 默认为null  如果root为null说明一个节点都没有
- 优先使用外部比较器
- 红黑树的旋转  四种情况的旋转


## 迭代器

- 迭代器遍历可以删除集合中的元素 ， 相对循环结构进行遍历可能会抛出异常

- ListIterator和Iterator的关系
  - 前者是后者的一个子类
  - 前者正逆向进行遍历，而后者只能正向遍历


## Collections 集合工具类

[Collections 集合工具类介绍相关代码](tools%2FCollectionsTest.java)


## 旧一代集合介绍

### Hashtable
- Hashtable继承Dictionary 
- 线程安全
- 不允许null值

### Vector
- 实现原理和ArrayList相同，功能相同，都是长度可变的数据结构
- Vector是早期JDK接口，ArrayList是替代Vector的新接口
- Vector线程安全、效率低、ArrayList线程不安全、效率高
- 扩容 Vector 是扩容2倍，ArrayList是扩容1.5
- 初始长度10

[TestVector.java](first%2FTestVector.java)

## 新一代并发集合类


- 第一代安全集合类
  - Vector 、 Hashtable
  - 使用synchronized修饰方法
  - 效率底下
- 第二代非安全集合类(主流)
  - ArrayList 、HashMap
  - 线程不安全，但是效率高
  - 如果需要线程安全则使用如下方法解决
    - Collections.synchronizedList(list)
    - Collections.synchronizedMap(map)
    - 底层还是使用synchronized代码块锁
- 第三代线程安全集合类(波浪式前进，螺旋式上升)
  - java.util.concurrent包下
    - ConcurrentHashMap
    - CopyOnWriteArrayList
    - CopyOnWriteArraySet
  - 底层大部分是采用Lock锁(JDK8的ConcurrentHashMap不是使用Lock锁),
  - 保证线程安全的同时，性能也不低

[ConcurrentHashMapTest.java](third%2FConcurrentHashMapTest.java)
[CopyOnWriteArrayListTest.java](third%2FCopyOnWriteArrayListTest.java)
[CopyOnWriteArraySetTest.java](third%2FCopyOnWriteArraySetTest.java)

[第一代第二代集合类案例代码.java](third%2FOtherTest.java)

- ConcurrentHashMap如何保证线程安全的
  - JDK7 
    - 分段(segment)锁 + Lock锁
    - 使用了锁分离技术
    - 使用多个锁来控制对hash表的不同部分(段segment)进行修改
    - 多个修改操作发生在不同的段上，因此可以并发运行，为此提高效率
  - JDK8
    - volatile + CAS 实现无锁化操作
    - 底层由 "数组" + 链表 + 红黑树的方式思想(JDK8中HashMap的实现)
    - 为了做到并发，有添加了很多辅助的类，如
      - TreeBin
      - Traverser
      - 等对象内部类


## 集合源码分析

源码分析这部分的代码全部存放目录[sources](sources)。

### 手写ArrayList

- 无参构造方法中 JDK1.7初始长度为10，JDK1.8中初始长度为0
- 每次扩容百分之50

[手写ArrayList的代码存放目录](sources%2FarrayList)

[实现的ArrayList代码.java](sources%2FarrayList%2FArrayList.java)

[测试程序.java](sources%2FarrayList%2FTestArrayList.java)

### 手写单双链表
[手写单双链表 代码存放位置](sources%2Flinked)

#### 单链表

[SingleNode.java](sources%2Flinked%2FsingleLinked%2FSingleNode.java)
[实现的单项List代码.java](sources%2Flinked%2FsingleLinked%2FSingleLinkedList.java)
[测试程序.java](sources%2Flinked%2FsingleLinked%2FTestSingleLinkedList.java)

#### 双链表 LinkedList类的实现


[实现的双向List代码.java](sources%2Flinked%2FdoubleLinked%2FDoubleLinkedList.java)

[测试程序.java](sources%2Flinked%2FdoubleLinked%2FTestDoubleLinkedList.java)
### 手写简易HashMap

- JDK7 是头插
- JDK8 是尾插

[手写HashMap基础功能 参考JDK7只有简单的put和get.java](sources%2FhashMap%2FHashMap.java)

[测试程序.java](sources%2FhashMap%2FTestHashMap.java)

### 手写简易的HashSet

- 底层就是一个HashMap 这里不过多介绍

[手写简易的HashSet.java](sources%2FHashSet%2FHashSet.java)
[测试程序.java](sources%2FHashSet%2FTestHashSet.java)




