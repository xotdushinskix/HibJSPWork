<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 10.05.16
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert jsp</title>
</head>
<body>
    <form action="/MainServlet" method="post">
    First name: <input type="text" name="firstname"> <br></br>
    Last name: <input type="text" name="lastname"> <br></br>
    Age: <input type="text" name="age"> <br></br>
    <input type="submit" name="enter" value="registration">
    </form>
</body>
</html>
