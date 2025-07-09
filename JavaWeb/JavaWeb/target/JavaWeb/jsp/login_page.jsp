<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/11
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录，注意重定向和转发的区别</title>
</head>
    <body>
        <form action="base/doLoginServlet">
            账号: <input type="text" name="username">     <br/>
            密码: <input type="password" name="password"> <br/>
            <button type="submit">提交</button>
        </form>
    </body>
</html>
