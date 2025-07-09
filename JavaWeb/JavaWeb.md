# 关于JavaWeb中的JSP、Tomcat、SpringMVC以及其框架等的基础使用

## JSP

- Java脚本
  - 小脚本 <% %>
    - 定义局部变量
  - 声明式 <%! %>
    - 定义的变量是成员变量 
    - 可以定义方法
  - 表达式 <%= %>

- 九个内置对象  不能在声明式中使用
  - request
  - response
  - out
  - seesion
  - application
  - page
  - config
  - pageContext
  - exception
- 静态包含 动态包含
  - 动态包含会产生class文件  静态包含不会产生class文件
  - 静态相当于代码的复制到新的文件  动态包含相当于方法的调用
  - 静态包含中包含的文件中不可以出现同名的变量(因为是代码的复制，为此一个变量不能被声明两次)  动态包含可以
  - 静态包含发生在第一步(翻译阶段)  动态包含发生在第三个阶段(class执行的阶段)
- jsp标签
  - 动作标识
    - jsp:include
    - jsp:forward
  - 指令标识
    - page
    - taglib
    - include


## 过滤器


## 拦截器 

## 监听器



## Spring 基础知识点
1. IOC
2. AOP
3. TX


## SpringMVC基础知识点

1. SpringMVC 的基本使用流程
2. SpringMVC 的单元方法获取请求
3. SpringMVC 的单元方法的响应方式
4. SpringMVC 处理异步ajax请求
5. SpringMVC 的自定义视图解析器
6. SpringMVC 的上传下载
7. 拦截器
8. 运行原理



