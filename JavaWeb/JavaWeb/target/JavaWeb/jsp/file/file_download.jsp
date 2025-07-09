<%@ page import="java.util.List" %>
<%@ page import="base.file_upload_download.entity.FileMessage" %><%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/12
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
    <base href="<%=request.getContextPath()+")"%>" ?>
</head>
    <body>
        <%!
            List<FileMessage> fileMessage = null;
        %>
        <%
            fileMessage = (List<FileMessage>) session.getAttribute("fileMessage");
            for (FileMessage message : fileMessage) {
        %>
            <span> <%=message.getUsername()%></span>
            <span> <%=message.getFilePath()%></span>
            <img src="<%=message.getFilePath()%>" alt="<%=message.getUsername()%>" style="width: 200px;height: 200px">
            <a href="/base/file_upload_download/fileDownLoadServlet?filename= + <%=message.getFilePath()%> + &filetype=image/jpeg" >  文件下载</a>
            <br/>
        <%
            }
        %>

    </body>
</html>
