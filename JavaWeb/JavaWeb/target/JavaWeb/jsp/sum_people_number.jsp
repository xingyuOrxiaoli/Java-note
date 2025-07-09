<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/11
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计网站访问人数</title>
</head>
    <body>
        <%--    声明式 --%>
        <%!
            int count = 0;
        %>
        <%--    小脚本 局部变量  不能定义方法  能使用JSP的内置对--%>
        <%
            int count = 0 ;
            count ++;
        %>
        <%--    表达式 --%>
        <%="本网站访问的人数（小脚本实现） : "+count%> <br/>

        <%--    声明式  成员变量 能定义方法   不能使用JSP的内置对象--%>
        <%!
            int count1 = 0;
        %>
        <%
            count1 ++;
        %>
        <%--    表达式 --%>
        <%="本网站访问的人数（声明式实现） : "+count1%>
    </body>
</html>
