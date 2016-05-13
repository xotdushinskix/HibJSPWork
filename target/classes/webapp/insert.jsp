<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 10.05.16
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insert jsp</title>
</head>
<body>

    <form method="POST" action="MainServlet" name="frmAddUser">
        User ID : <input type="text" readonly="readonly" name="userid" value="<c:out value="${user.userId}" />" />
        <br/>
        First Name : <input type="text" name="firstname" value="<c:out value="${user.firstName}" />" />
        <br/>
        Last Name : <input type="text" name="lastname" value="<c:out value="${user.lastName}" />" />
        <br/>
        Age : <input type="text" name="age" value="<c:out value="${user.age}" />" />
        <br/>
        <input type="submit" value="Submit" />
    </form>

</body>
</html>
