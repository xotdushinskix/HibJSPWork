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
<h3>Information and action</h3>


<h3>All users list:</h3>
<c:forEach items="${users}" var="user1">
    <table border="1" cellpadding="7" cellspacing="0">
        <tr>
            <td>${user1.userId}</td>
            <td>${user1.firstName}</td>
            <td>${user1.lastName}</td>
            <td>${user1.age}</td>
            <td><a href="MainServlet?action=edit&userId=<c:out value="${user1.userId}"/>">Update</a></td>
            <td><a href="MainServlet?action=delete&userId=<c:out value="${user1.userId}"/>">Delete</a></td>
        </tr>
    </table>
</c:forEach>
<p><a href="MainServlet?action=insert">Add User</a></p>
</body>
</html>
