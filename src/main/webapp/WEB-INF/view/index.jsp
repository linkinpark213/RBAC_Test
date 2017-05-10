<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 2017/5/8 0008
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Blog Index</title>
    <script src="/public/js/jquery.js"></script>

</head>
<body>
<div id="main-container">
    <div id="login-frame">
        <input type="number" value="1" name="id" id="user-id"/>
        <input type="button" id="login-btn" value="Login" onclick="login()"/>
    </div>
    <div id="articles">

    </div>
</div>
<script>
    function login() {
        $.ajax({
            url: "/login",
            type: "get",
            dataType: "json",
            data: {
                "user-id": $('#user-id').val()
            },
            success: function (data) {
                console.log(data.length);
                var articles = $('#articles');
                articles.html('');
                for (var i = 0; i < data.length; i++) {
                    articles.append("<div>" +
                        "<a><h2>" +
                        data[i].title +
                        "</h2></a>" +
                        "<p>" +
                        data[i].content +
                        "</p>" +
                        "</div>"
                    );
                }
            },
            error: function () {
                alert("Login Failed.");
            }
        })
    }

</script>
</body>
</html>
