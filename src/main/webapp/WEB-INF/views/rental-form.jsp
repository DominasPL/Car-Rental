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
        <form:select itemValue="id" itemLabel="name"
                     path="hirePlace.id" items="${places}"/> <br>

        Return place
        <form:select itemValue="id" itemLabel="name"
                     path="returnPlace.id" items="${places}"/> <br>

        <label for="start">Hire date:</label>
        <input type="date" id="start" name="date" min="2019-01-01" max="2020-12-31"> <br>

        <label for="start">Return date:</label>
        <input type="date" id="start" name="date" min="2019-01-01" max="2020-12-31"> <br>

        <input type="submit" value="Submit">
    </form:form>


</body>
</html>
