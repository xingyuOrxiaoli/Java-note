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
    <title>请求转发页面</title>
    <base href="<%=request.getContextPath()+")"%>" ?>
</head>
    <body>
       <h1>
           forward  请求转发页面
       </h1>
       <h1>request参数为： ${requestScope.mvc_data_request}</h1>
       <h1>session参数为： ${sessionScope.mvc_data_session}</h1>
       <h1>application参数为： ${applicationScope.mvc_data_application}</h1>
       <h1>model参数为： ${requestScope.mode_attribute}</h1>
    </body>
</html>
