<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>

<%--<form action="/MainServlet" method="post">--%>
    <%--First name: <input type="text" name="firstname"> <br></br>--%>
    <%--Last name: <input type="text" name="lastname"> <br></br>--%>
    <%--Age: <input type="text" name="age"> <br></br>--%>
    <%--<input type="submit" name="enter" value="registration">--%>
    <%--&lt;%&ndash;<input type="submit" name="editUser" value="edit">&ndash;%&gt;--%>
<%--</form>--%>
<%--&lt;%&ndash;<a href="userinfojsp">Go to the information page</a>&ndash;%&gt;--%>
<jsp:forward page="/MainServlet?action=showAll" />

</body>
</html>
