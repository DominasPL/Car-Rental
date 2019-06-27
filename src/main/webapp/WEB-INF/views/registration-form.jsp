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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

    <a class="btn btn-primary" href="/" role="button">Main page</a>
    <a class="btn btn-primary" href="/login" role="button">Login</a>
    <a class="btn btn-primary" href="/register" role="button">Registration</a>
    <a class="btn btn-primary" href="/edit" role="button">Edit</a>
    <a class="btn btn-primary" href="/logout" role="button">Logout</a>

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
