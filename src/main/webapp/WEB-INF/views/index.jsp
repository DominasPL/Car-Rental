<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/20/19
  Time: 4:27 PM
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

<h1>Main Page</h1>

    <a class="btn btn-primary" href="/user" role="button">Main page</a>

    <sec:authorize access="!isAuthenticated()">
        <a class="btn btn-primary" href="/login" role="button">Login</a>
        <a class="btn btn-primary" href="/register" role="button">Registration</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <a class="btn btn-primary" href="/user/rental" role="button">Rent a car</a>
        <a class="btn btn-primary" href="/user/edit" role="button">Edit</a>
        <a class="btn btn-primary" href="/logout" role="button">Logout</a>
    </sec:authorize>



</body>
</html>
