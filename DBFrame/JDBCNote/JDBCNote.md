# 关于JavaJDBC相关内容的介绍

**Java语言实现对多种数据库提供统一访问**

- **使用**JDBC中核心的接口与类
  - DriverManager 类，作用：管理各种不同的JDBC驱动
  - Connection 接口
  - Statement 和PrepareStatement
  - ResultSet


## Statement进行CRUD操作

[代码存放位置](src%2Fmain%2Fjava%2Fcom%2Flxy%2FStatement)

[删除元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FStatement%2FTestDelete.java)

[添加元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FStatement%2FTestInert.java)

[查询元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FStatement%2FTestSelect.java)

[更新元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FStatement%2FTestUpdate.java)
## PreparedStatement进行CRUD操作

[代码存放位置](src%2Fmain%2Fjava%2Fcom%2Flxy%2FPreparedStatement)

[添加元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FPreparedStatement%2FTestInert.java)

[更新元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FPreparedStatement%2FTestUpdate.java)

[查询元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FPreparedStatement%2FTestSelect.java)

[删除元素.java](src%2Fmain%2Fjava%2Fcom%2Flxy%2FPreparedStatement%2FTestDelete.java)


## API汇总

- Connection
  - close()
  - commit()
  - createStatement()
  - **prepareCall**(String sql) 创建一个CallableStatement对象来调用存储工程
  - prepareStatement()
  - rollback()
  - setAutoCommit()

