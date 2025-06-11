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