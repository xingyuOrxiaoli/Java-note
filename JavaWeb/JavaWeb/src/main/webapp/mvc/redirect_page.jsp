<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/13
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重定向页面</title>
    <base href="<%=request.getContextPath()+")"%>" ?>
</head>
    <body>
       <h1>
           redirect  重定向页面
       </h1>
       <h1>model参数为： ${requestScope.mode_attribute}</h1>

    </body>
</html>
