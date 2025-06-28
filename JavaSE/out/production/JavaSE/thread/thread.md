# 关于Java中多线程的使用



|  区别  |                            进程                             |                             线程                             |
|:----:|:---------------------------------------------------------:|:----------------------------------------------------------:|
| 根本区别 |                         作为资源分配的单位                         |                          调度和执行的单位                          |
|  开销  |          每个进程都有独立的代码和数据空间(进程上下文)，进程间的切换会有比较大的开销           | 线程可以堪称轻量级的进程，同一类线程共享代码和数据空间，每个线程又独立的运行栈和程序计数器(PC)，线程切换的开销小 |
| 所处环境 |                    再操作系统中能同时运行多个任务(程序)                    |                     在同一应用程序中有多个顺序流同时执行                     |
| 分配内存 |                 系统在运行的时候会为每一个进程分配不同的内存区域                  |       除了CPU外，不会为线程分配内存(线程所使用的资源是它所属的进程的资源),线程组只能共享资源       |
| 包含关系 | 没有线程的进程可以被看作单线程，如果一个进程内拥有多个线程，则执行过程不是一条线的，而是对条线的(线程)功能完成的 |                线程是进程的一部分，所以线程有的时候被称为是轻量级进程                 |





## 继承Thread (没有返回值)

- Priority  线程的优先级别
- Name      线程的名称
- start()   启动,进入就绪队列，等会带获取CPU


[继承Thread使用方法](base/ThreadTest1.java)

## 实现Runnable接口(没有返回值)


[实现Runnable接口使用方法](base/RunnableTest1.java)


## 实现Callable接口(有返回值)
[实现实现Callable接口使用方法](base/CallableTest1.java)



## 线程控制
 
 - thread.join()  阻塞指定线程等到另一个线程完成以后再继续执行
 - thread.yield() 
   - 使线程停止运行一段时间，让出CPU，处于阻塞状态
   - 如果调用了sleep方法之后，没有其他等待执行的线程，这个时候当前线程不会马上恢复执行
 - thread.setDaemon(true) 后台线程，守护线程 寄生线程  主线程执行之后其他线程也停止的作用
 - thread.interrupt()   修改线程的状态，还需要线程本身检查状态的变化（thread.isInterrupted()）  而不是直接中断线程
 - 


## 线程同步

- 同步代码块
  - 总结1 synchronized(同步监视器)
      - 必须是引用数据类型，不能是基础数据类型
      - 在同步代码块中可以改变同步监视器对象的值，不能改变其引用
      - 尽量不要String和包装类Integer做同步监视器。如果使用了，只要保证代码块中不对其进行任何操作也没有关系
      - 一般使用共享资源做同步监视器即可
      - 也可以创建一个专门的同步监视器，没有任何业务含义
      - 建议使用final修饰同步监视器
  - 总结2 同步代码块的执行过程
    - 第一个线程来到同步代码块，发现同步监视器open状态，需要close，让后执行了其中的代码
    - 第一个线程执行过程中,发现了线程切换(阻塞,就绪) ,第一线程失去了cpu，但是没有开锁open
    - 第二个线程获取cpu，来到了同步代码块，发现同步监视器close状态，无法执行其中的代码，第二个线程也进入阻塞状态
    - 第一个线程再次获取cpu，接着执行后续的代码，同步代码块执行完毕，释放锁open
    - 第二个线程也再次获取cpu,发现锁是open的，拿到锁并上锁，由阻塞状态进入就绪状态，再次进入运行状态，重复第一个线程的处理过程(加锁)
    - **【强调】：** 
      - 同步代码块中能发生线程切换
      - 但是发生线程切换，后续的被执行的线程也无法执行同步代码块中的代码（锁仍旧close）
  - 总结三：线程同步的 优缺点
    - 优点：安全
    - 缺点：效率低，可以出现死锁
  - 其他：
    - 多个代码块使用同一个同步监视器(锁)，锁住一个代码块的同时，也锁住了使用该锁的所有代码块，其他线程无法访问其中的任何一个代码块
    - 多个代码块使用同一个同步监视器(锁)，锁住一个代码块的同时，也锁住了使用该锁的所有代码块，但是没有锁住使用其他同步监视器的代码块，其他线程有机会访问其他同步监视器的代码块

[同步代码块.java](lock/SynchronizedTest1.java)

- 同步方法
  - 成员方法锁的是this
  - 静态方法锁的是类对象
  - 同步方法与同步代码块效率对比
    - 同步代码块的效率更高一些

[同步代码块.java](lock/SynchronizedTest2.java)
 
- Lock锁
  - Lock锁和synchronized的区别
    - Lock是显式锁(手动开启和关闭锁，别忘记关闭锁),synchronized是隐式锁，遇到异常自动解锁
    - Lock只有代码块锁,synchronized有代码块锁和方法锁
    - Lock锁可以对读不加锁，对写加锁,synchronized不可以
    - Lock锁可以有多种获取锁的方式，可以从sleep的线程中抢到锁 synchronized不可以
    - 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好，并且具有更好的扩展性(提供更多的子类)
- 优先使用顺序
  - Lock
  - 同步代码块(已经进入了方法体，分配了相应的资源)
  - 同步方法(在方法体之外)

[Lock锁.java](lock/LockTest3.java)

## 练习

### 三种实现保证多个窗口买票

[实现 多个窗口买票](lock/TicketTest.java)

### 线程的通信 

- wait() 表示线程一直等待,直到其他线程通知
- wait(long timeout) 线程等待指定毫秒参数的时间
- wait(long timeout, int nanos) 线程等待指定毫秒、微妙的时间
- notify()     唤醒一个处于等待状态的线程
- notifyAll() 唤醒同一个对象上所有调用wait()方法的线程优先级别高的线程优先运行


#### 生产者消费者练习1 1 v 1

[一个生成一个消费者案例代码存放目录](producerConsumer%2FV1_1)

[一个生产者一个消费者的测试程序](producerConsumer/V1_1/ProducerConsumerTest1V1.java)


#### 生产者消费者练习2 n v n synchronized 
[生产者消费者练习 n个消费者和生产者，最大存储为max个](producerConsumer%2FVn_n_synchronized)

[测试程序.java](producerConsumer%2FVn_n_synchronized%2FProducerConsumerTestnVn.java)

#### 生产者消费者练习3 n v n lock

#### 生产者消费者练习1 1 v n

#### 生产者消费者练习1 n v 1

#### 注意细节

- 进行线程通信的多个线程，要使用同一个同步监视器product，还必须要调用该同步监视器的wait()、notify()、notifyAll()
- 线程通信的三个方法  
  - 等待 wait()
  - 通知 唤醒 notify() (使用必须先上锁)
  - 通知所有 唤醒所有 notifyAll()
- 完整的线程生命周期
  - 阻塞状态的三种
- sleep和wait的区别 
  - sleep不是放锁 wait释放锁
  - sleep进入阻塞队列  wait进入等待队列
  - wait只能在同步控制方法或者同步控制块里面使用 sleep可以在任何地方使用


- Condition
  - Condition可以更加精细的控制多线程的休眠和唤醒
  - 在Object的监视器模型上，只有一个等待队列和阻塞队列
 

## 线程池 ThreadPoolExecutor

- 优缺点
  - 提高响应速度
  - 降低资源的消耗
  - 提高线程的可管理性
- 场景
  - 需要大量线程，并且完成任务的时间短
  - 对性能要求苛刻
  - 接受突发性的大量请求

- JDK5起，提供了内部线程池

[使用线程池执行大量的Runnable命令/任务](pool%2FThreadPoolExecutorTest1.java)

[使用线程池执行大量的Callable任务.java](pool%2FThreadPoolExecutorTest2.java)

线程池ThreadPoolExecutor参数
```java
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             threadFactory, defaultHandler);
    }
```
- corePoolSize 核心池的大小
  - 默认，创建线程池后，线程数为 0 ，当来任务之后就会创建一个线程去执行任务
  - 但是当线程池中线程数量达到corePoolSize，就会把到达的任务放到队列中等待
- maximumPoolSize 最大线程数
  - corePoolSize 和 maximumPoolSize之间的线程数会自动释放，小于等于corePoolSize不会释放。当大于了这个值就会将任务由一个丢弃处理机制来处理
- keepAliveTime 时间数值部分
- unit  时间数值的单位

## ForkJoin框架

主要类

- ForkJoinTask
  - 使用该框架，需要创建一个ForkJoin任务，它提供在任务中执行fork和join操作的机制，一般情况下，我们并不需要直接继承ForkJoinTask类，只需继承它的子类
    - RecursiveAction 用于没有返回值的任务
    - RecursiveTask   用于有返回值的任务
- ForkJoinPool
  - 任务ForkJoinTask需要通过ForkJoinPool来执行
- ForkJoinWorkerThread
  - ForkJoinPool线程池中的一个执行任务的线程

### 求和案例













