<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/29/19
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rental form</title>
</head>
<body>

    <h1>This is a rental form!</h1>
    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/> <br>

        Hire place
        <form:input path="hirePlace"/> <br>

        Return place
        <form:input path="returnPlace"/> <br>

        Hire date
        <form:input path="hireDate"/> <br>

        Return date
        <form:input path="returnDate"/> <br>

        <input type="submit" value="Submit">
    </form:form>


</body>
</html>
