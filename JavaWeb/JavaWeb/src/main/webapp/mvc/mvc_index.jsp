<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
    <head>
        <title>MVC内容</title>
    </head>
    <body>
        <h2>你好 MVC </h2>
        <ol>
            <li><a href="/mvc/test">mvc的单元测试方法</a></li>
            <li><a href="/mvc/gain_data_req?username=username&password=password">mvc 紧耦合的方式获取请求数据</a></li>
            <li><a href="/mvc/gain_data_mvc?username=username&password=password">mvc 解耦合的方式获取请求数据</a></li>
            <li><a href="/mvc/gain_data_mvc/username1/password">mvc restful格式传输</a></li>
            <li><a href="/mvc/req_ArgCode?username='你好世界'">request解决中文乱码的问题 iso-8859-1</a></li>
            <li><a href="/mvc/req_ArgCode?username='你好世界'">springmvc 过滤编码(看配置文件) 解决中文乱码的问题 iso-8859-1</a></li>
            <li><a href="/mvc/static_page.jsp">mvc 的静态资源放行 </a></li>
            <li><a href="/mvc/response">response对象完成响应 </a></li>
            <li><a href="/mvc/mvc_forward">mvc forward forward 关键字可以省略不写 </a></li>
            <li><a href="/mvc/mvc_redirect">mvc redirect </a></li>
            <li><a href="/mvc/mvc_data_request">mvc_data_request 请求转发</a></li>
            <li><a href="/mvc/mvc_data_session">mvc_data_session 请求转发 </a></li>
            <li><a href="/mvc/mvc_data_application">mvc_data_application 请求转发</a></li>
            <li><a href="/mvc/mvc_data_model1">mvc_data_model1 请求转发 </a></li>
            <li><a href="/mvc/mvc_data_model2">mvc_data_model2 重定向 </a></li>
            <li><a href="/mvc/demoView"> demoView 自定义视图解析器 </a></li>
            <li><a href="/mvc/demoModelAndView"> demoModelAndView 自定义视图解析器 </a></li>

            <li><a href="/mvc/mvc_file_upload.jsp"> ajax -  mvc_file_upload SpringMVC文件上传 </a></li>
            <li><a href="/mvc/mvc_file_download.jsp"> ajax -  mvc_file_upload SpringMVC文件下载 </a></li>
        </ol>
        
    </body>
