<%--
  Created by IntelliJ IDEA.
  User: lixin
  Date: 2024/12/13
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <base href="<%=request.getContextPath()+")"%>" ?>
    <script src="js/jquery3.7.1.js"></script>

    <script>
        $(function () {
            $("#fileUploadButton").click(function (){
                // 获取要上传的文件资源
                var file = $("#file")[0].files[0];
                // 创造FormData对象存储要上传的资源
                var formdata = new FormData();
                formdata.append("photo",file)
                // 发起ajax请求完成操作
                $.ajax({
                    type:"post", // 使用post类型的请求方式
                    data:formdata,  // 请求数据
                    url:"", // 请求地址
                    processData:false,
                    contentType:false,
                    success:function (data) { // 回调函数
                        // 将响应数据转换为json对象
                        eval("var result = " + data);
                        console.log(result);

                    }

                })


            })
        })
    </script>
</head>
    <body>
    <form action="">
        <input type="file" id="file">  &nbsp; &nbsp;
        <a href="javascript:void(0)" id="fileUploadButton">文件上传</a>
        <button>表单提交</button>
    </form>
       
    </body>
</html>
