<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/20/19
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Registration</h1>
    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/> <br>

        Username
        <form:input path="username"/> <br>

        Password
        <form:password path="password"/> <br>

        Confirm password
        <form:password path="confirmedPassword"/> <br>

        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
