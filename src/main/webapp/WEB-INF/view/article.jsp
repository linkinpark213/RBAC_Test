<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 2017/5/10 0010
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${article.title}</title>
</head>
<body>
<h2>${article.title}</h2>
<br>
<p>${article.content}</p>
<br>
<div id="comment-container">

</div>
</body>
</html>
