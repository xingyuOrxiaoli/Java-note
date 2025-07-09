<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/11
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP include的使用</title>
</head>
    <body>
        <%--动作表示--%>
        <jsp:include page="page/jsp_include_page_header.jsp"></jsp:include>
    
        <jsp:forward page="page/jsp_forward_page.jsp"></jsp:forward>
        <%--指令标识    page  taglib   include--%>
        <%@include file="page/include_file_page.jsp"%>


    </body>
</html>
