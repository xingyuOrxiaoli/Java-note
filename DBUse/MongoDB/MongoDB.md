# 关于MongoDB使用记录

- 数据结构对比
  - 数据库
  - 集合
  - 文档
  - 字段
  - 嵌入文档
  - 主键(MongoDB提供了 key 为 _id)
- 服务和客户端
  - mongod  服务端
  - mongo   客户端

## 数据结构

| 类型           |                           介绍                           |
|:-------------|:------------------------------------------------------:|
| String       |       字符串,存储数据常用的数据类型,在MongoDB中，UTF-8编码的字符串才是合法的       |
| Integer      |           整型数值,用于存储数值,根据你所采用的服务器,可分为32位或64位            |
| Boolean      |                    布尔值,用于存储布尔值(真假)                     |
| Double       |                     双精度浮点值,用于存储浮点值                     |
| Min/Max keys |            将一个值与BSON(二进制的JSON)元素的最低值和最高值相对比            |
| Array        |                   用于将数组或列表或多个值存储为一个键                   |
| Timestamp    |                   时间戳，记录文档修改或添加的具体时间                   |
| Object       |                         用于内嵌文档                         |
| Null         |                         用于创建空值                         |
| Symbol       |       符号,该数据类型基本上等同于字符串类型,但不同的是，它一般用于采用特殊符号类型的语言       |
| Date         | 日期时间，用于UNIX时间格式来存储当前日期或时间，你可以制指定自己的时间:创建Date对象传入年月日信息  |


## 启动


- 前置启动 ： bin/mongod  --dppath /opt/data/db（存放数据的目录） --logpath 日志存放目录/mongodb.log
- 后置启动 ： bin/mongod  --dppath /opt/data/db（存放数据的目录） --logpath 日志存放目录/mongodb.log --fork 
- 默认端口 ： 27017
- 连接命令 ： mongo
- 关闭命令 ： mongod --shutdown --dppath /opt/data/db（存放数据的目录）
- 配置启动



## 索引


## 集群



### 术语
- Shard  用于存储实际的数据块，实际生产环境种一个shard server角色可由几台机器组一个replica set承担 方式主机单节点故障
- Config Server 
- Routers
- Shard Key
- Range分区
- Hash分区


