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
<h6>All users list:</h6>
<c:forEach items="${getAllUser}" var="user1">
    <tr>
        <td>${user1.userId}</td> <br></br>
        <td>${user1.firstName}</td> <br></br>
        <td>${user1.lastName}</td> <br></br>
        <td>${user1.age}</td> <br></br>
    </tr>
</c:forEach>
</body>
</html>
