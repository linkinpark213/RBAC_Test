<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 2017/5/10 0010
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error!</title>
</head>
<body>
Permission Denied.
<script>
    window.onload = function () {
        var timer = setInterval(function () {
            clearInterval(timer);
            location.href = "/";
        }, 3000);
    }
</script>
</body>
</html>
