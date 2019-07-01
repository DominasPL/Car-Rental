<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/28/19
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>

    <h1>This is an admin panel!</h1>
    <a class="btn btn-primary" href="/admin/users" role="button">Users</a>
    <a class="btn btn-primary" href="/admin/admins" role="button">Admins</a>
    <a class="btn btn-primary" href="/admin/rentals" role="button">Rentals</a>
    <a class="btn btn-primary" href="/logout" role="button">Logout</a>

</body>
</html>
