# MyBatisNote相关的使用的知识点


## 基础使用案例

- [A01目录 通过Test案例使用MyBatis框架对MySQL数据库简单的查询](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA01)
  - [中文文档连接](https://mybatis.org/mybatis-3/zh_CN/configuration.html)
  - [mybatis配置文件相关使用.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA01%2Fmybatis.xml)
    - &amp 如果直接配置文件填写需要使用这个转义符号
  - [mybatis中的mapper文件相关使用.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA01%2Fmapper%2FTest1Mapper.xml)
  - [mybatis中的运行文件1.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA01%2FTest1A01.java)
 
## 三种查询的方式

- [A02目录 三种查询的方式案例代码存放目录](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA02)
  - [三种查询的方式测试的配置文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA02%2Fmapper%2FSelectMethod1.xml)
  - [三种查询的方式测试查询代码.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA02%2FTestSelectMethod1.java)


## 参数传递
- [A03目录 参数传递案例存放代码文件](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA03)
  - [三种参数传递测试的配置文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA02%2Fmapper%2FSelectMethod1.xml)
  - [三种参数传递测试代码.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA02%2FTestSelectMethod1.java)

## CRUD 功能实现
- [A04目录 CURD案例存放代码文件](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA04)
  - [CRUD测试的配置文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA04%2Fmapper%2FCRUD.xml)
  - [CRUD测试代码.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA02%2FTestSelectMethod1.java)
- mapper动态代理
  - [使用Mapper代理测试CRUD测试代码.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA04%2FTestParamMethod2.java)
  - [使用Mapper代理测试CRUD的配置文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA04%2Fmapper%2FCRUD2Interface.xml)
  - [使用Mapper代理测试CRUD的Mapper接口.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA04%2Fmapper%2FCRUD2Interface.java)


## SQL语句的动态拼接

- [动态SQL案例配置文件的内容](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA05%2Fmapper%2FSQLMapper.xml)
  - if 
  - where
  - choose when otherwise
  - set
  - trim
  - foreach list为容器的key array是数组的key mybatis把集合和数组封装到一个map中
  - bind 字符串拼接
  - sql    
  - include
- [测试文件.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA05%2FTestSQL.java)


## 多表查询

[A06 多表查询存放案例代码的位置](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA06)

- 业务代码查询
  - [业务代码方式实现测试代码.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA06%2FServiceCodeTest.java)
  - [业务代码方式实现XML文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA06%2Fmapper%2FServiceCode.xml)
- N + 1 方式
  - [N + 1 方式实现测试代码.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA06%2FN1Select.java)
  - [N + 1 方式实现XML文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA06%2Fmapper%2FN1Mapper.xml)
- 多表查询SQL
  - 方案1：新建一个实体类 包含多个和实体的信息
  - 方案2：使用resultMap  不能省去每个字段的映射 使用多表查询SQL
  - [多表查询SQL方式实现XML文件.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FA06%2FMoreSQLSelect.java)
  - [多表查询SQL方式实现XML文件.xml](src%2Fmain%2Fresources%2Fcom%2Flxy%2FA06%2Fmapper%2FMoreSQLMapper.xml)


## MyBatis缓存

- 好处 好 
- 坏处 可能出现脏读等问题
- 一级缓存 默认是开启的
  - sqlsession级缓存 
  - 同一个sqlSession，同一调sql 会从缓存拿(如果缓存中有，没有查询到再放到缓存中。下次缓存就有了)
- 二级缓存 默认没有开启
  - factory级别的缓存 
  - 在mapper.xml文件 设置 <cache readOnly="true"></cache>



## TheadLocal 
- 底层是一个map集合 线程的id为key  value 为SqlSession对象 
- 实现一个请求不论多少次调用都是sqlSession对象
- ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();







