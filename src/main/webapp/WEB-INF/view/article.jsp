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
    <script src="/public/js/jquery.js"></script>
</head>
<body>
<c:if test="${user!= null}">
    Logged in as user #${user.id}
    <br>
    <a href='/'>Log Out</a>
</c:if>
<c:if test="${permittedOperations[2]==true}">
    <h2>${article.title}</h2>
    <br>
    <p>${article.content}</p>
    <br>
    <div id="comment-container">
        <c:forEach var="comment" items="${comments}">
            <div class="comment">
                User #${comment.userId}:
                <br>
                    ${comment.content}
                <br>
            </div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${permittedOperations[1]==true}">
<div>
    <hr>
    <form action="/resubmit" method="post">
        Edit Article:
        <br>
        <input type="hidden" name="article-id" value="${article.id}"/>
        <input type="text" value="${article.title}" name="resubmit-title"/>
        <br>
        <textarea name="resubmit-content" style="width: 500px; height: 100px;">${article.content}</textarea>
        <br>
        <input type="submit" id="resubmit-article" value="Submit Edition"/>
        <br>
    </form>
    </c:if>
</div>
<c:if test="${permittedOperations[3]==true}">
    <hr>
    <form action="/comment" method="post">
        Comment:
        <input type="hidden" name="article-id" value="${article.id}"/>
        <input type="text" name="comment" placeholder="Make your comment:"/>
        <input type="submit" value="Submit" id="submit-comment"/>
    </form>
</c:if>
</body>
</html>
