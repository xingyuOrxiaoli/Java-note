<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/11
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取时间案例</title>
    <script type="text/javascript">
        function gain_time(){
            var date = new Date();
            // 获取时间
            var time = date.toLocaleDateString();
            document.getElementById("gain_time").innerText = time;
        }
    </script>
</head>
    <body onload="gain_time()">
        获得时间（JavaScript）      : <span id="gain_time"></span> <br/>
        <%--  小脚本 ： 可以书写java代码      --%>
        <%
            Date date = new Date();
            String time = date.toLocaleString();
        %>
                                    <%--   表达式:里面写输出内容语句     --%>
        获得时间（Java小脚本 + 表达式）: <%="获得时间(服务器时间)：" + time%> <br/>


    </body>
</html>
