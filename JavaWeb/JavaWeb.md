# 关于JavaWeb中的JSP、Tomcat等的基础使用

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
    - 