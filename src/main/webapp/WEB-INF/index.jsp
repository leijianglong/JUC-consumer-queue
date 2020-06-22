<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/22 0022
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<div>
    <h1>首页</h1>
    <form id="registerForm" action="/system/register" method="post"  target="frame1">
        邮箱:<input type="text" name="email" />
        <br>
        密码:<input type="text" name="passcode" />
        <br>
        <button type="button" onclick="registerSubmit()">提交</button>
    </form>

    <iframe name="frame1" frameborder="0" id="frame"></iframe>
</div>
</body>
<script>
    function registerSubmit(){
        var form = document.getElementById("registerForm");
        form.submit();
        window.location = "/system/index";
    }

</script>
</html>
