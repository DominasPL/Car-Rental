<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/27/19
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</head>
<body>

    <a class="btn btn-primary" href="/" role="button">Main page</a>
    <a class="btn btn-primary" href="/login" role="button">Login</a>
    <a class="btn btn-primary" href="/register" role="button">Registration</a>
    <a class="btn btn-primary" href="/logout" role="button">Logout</a>

    <h1>Personal details</h1>
    <form:form modelAttribute="form" method="post">
        <form:errors path="*"/> <br>

        First name
        <form:input path="firstName"/> <br>

        Last name
        <form:input path="lastName"/> <br>

        Email
        <form:input path="email"/> <br>

        Phone number
        <form:input path="phoneNumber"/> <br>

        Address
        <form:input path="address"/> <br>

        Postal code
        <form:input path="postalCode"/> <br>


        <input type="submit" value="Submit">
    </form:form>


</body>
</html>
