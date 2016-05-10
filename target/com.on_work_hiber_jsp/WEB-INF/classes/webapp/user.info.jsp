<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 10.05.16
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users info</title>
</head>
<body>
<c:forEach items="${getAllUsers}" var="user">
    <tr>
        <td>${user.userId}</td>
        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
        <td>${user.age}</td>
    </tr>
</c:forEach>
</body>
</html>
