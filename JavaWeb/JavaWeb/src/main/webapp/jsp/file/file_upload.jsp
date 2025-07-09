<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/12
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <base href="<%=request.getContextPath()+")"%>" ?>
</head>
    <body>
        <%-- enctype 属性 ：
                【A】    application/x-www-form-urlencoded  （默认） 提交表单的内容，按照文本进行传输
                【B】    multipart/form-dat                 提交的表单内容按照二进制流的方式进行传输

        --%>
        <form action="/base/file_upload_download/fileUpLoadServlet" method="post" enctype="multipart/form-data">

            账号     : <input type="text" name="username">
            文件上传  : <input type="file" name="fileUpload">
            <button type="submit">文件上传</button>
        </form>
    </body>
</html>
