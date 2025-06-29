# 关于MySQ使用记录

## 基础知识

- 数据库查询语言 DQL
  - select字句 from字句和where字句的组合来查询一条或多条数据
- 数据操作语言DML 对数据的 增删改
  - insert
  - update
  - delete

- 数据定义语言DDL 
  - 主要针对数据库对象
    - 表
    - 数据库
    - 索引
    - 视图
    - 触发器
    - 存储过程
    - 函数
  - 语句
    - create 创建数据库对象
    - alter  修改数据库对象
    - drop   删除数据库对象
- 数据控制语言 DCL 授予或者回收数据库的泉下
  - GRANT 授予用户某种权限
  - REVOKE 回收授予的某种权限
- 事物控制语言 TCL用于管理数据库的事物
  - start transaction  开始事务
  - commit             提交事物
  - rollback           回滚事物
  - set transaction    设置事物的属性

DML和DDL的不同
- DML 针对数据表中的数据
- DDL 针对的是数据表的结构





## DML

[DML.sql](sql%2FDML.sql)

## DDL
[DDL.sql](sql%2FDDL.sql)
- desc  查看结构
- drop  删除
- alter 添加


### 表的完整性约束
- primary key                    主键
  - 放到后面
  - 最后加上constraint 约束名称 primary key(字段)
- auto_increment                 自增
- not null                       非空
- check(sex = '男' || sex = '女') 约束
  - 最后使用  or  and
- unique                         唯一
- default                        默认值
- foreign key                    外键约束
  - constraint 约束名称 foreign key(字段名) references 参考表(参考字段)
  - alter table table1 add constraint 约束名称 foreign key (字段) references 参考表(参考字段)
  - 外键策略
    - No Action 删除父点 需要没有孩子节点
    - cascade级联  同时修改和删除孩子节点
      - constraint 约束名称 foreign key(字段名) references 参考表(参考字段) on update cascade on delete cascade
    - set null 设置为空
      - constraint 约束名称 foreign key(字段名) references 参考表(参考字段) on update set null on delete set null
    


**添加一个约束**

- alter table 表名  add constraint 约束名称 primary key(字段)

## DQL

[DQL.sql](sql%2FDQL.sql)

### 多表查询

**内连接**
- 交叉链接  cross join
- using
- on
- 自然连接 natural join

**外连接**
对于 没有匹配的数据，还会显示没有匹配的数据 left 表示显示左边表没有匹配的 right反之
- 左外连接 left join
- 右外连接 right join
- 全外连接 full  join

[DQL_moreTables.sql](sql%2FDQL_moreTables.sql)


## 索引

[index.sql](sql%2Findex.sql)

对数据库优化的主要手段

- 分类1：单列索引和多列索引
- 分类2：唯一所以和唯一索引
- 分类3：存储结构
  - B-Tree
  - R-Tree
  - Hash

## 事务

[trainsaction.sql](sql%2Ftrainsaction.sql)

维护数据完整性的手段

满足ACID四个特性的操作序列就是事物

- A : 原子性
  - 不可分割的特性，多个操作作为一个整体
- C : 一致性
  - 从一个一致性状态，变道另外一个一致性状态
- I : 隔离性
  - 各个事务互不干扰
- D : 持久性
  - 一旦提交，数据就会改变

### 事务的并发问题

**问题：**  
- 脏读
  - 读取的数据是某个状态的中间值，但是那个状态可能被回滚，导致出现脏读
- 不可重复读
  - 先读取数据，之后另外一个事务提交了并修改了读取的值 ，导致多次读的数据不一样
- 幻读
  - A查询数据数量 之后B添加一条数据并提交了，为此A两次查询的数据不一样
  
**[不可重复读和幻读的区别]**
- 不可重复度侧重对数据 修改
- 幻读是对数据的添加删除


### 事务的隔离级别

|              隔离级别              |  脏读  | 不可重复读  |  幻读  |
|:------------------------------:|:----:|:------:|:----:|
| READ_UNCOMMITTED (可以读还未提交的数据)  |  存在  |   存在   |  存在  |
|         READ COMMITTED         | 不存在  |   存在   |  存在  |
|      REPEATABLE-READ(默认)       | 不存在  |  不存在   |  存在  |
|          SERIALIZABLE          | 不存在  |  不存在   | 不存在  |


## 视图 view

视图就是一个 虚拟的表 

[view.sql](sql%2Fview.sql)


## 存储过程

[procedure.sql](sql%2Fprocedure.sql)



## 函数


## 用户管理

- 用户管理

[用户的创建，用户的信息的修改 .sql](sql%2FuserMessageManager.sql)

- 权限管理

[如何查询、添加、撤销用户的权限.sql](sql%2FuserPowerManager.sql)

- 角色管理
[创建角色，给用户分配角色、激活角色、撤销角色和删除角色.sql](sql%2FuserRoleManager.sql)










