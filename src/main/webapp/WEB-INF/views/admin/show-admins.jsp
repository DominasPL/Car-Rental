<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/29/19
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admins</title>
</head>
<body>

    <h1>All users</h1>
    <c:forEach items="${admins}" var="admin" varStatus="adminStatus">
        <tr>
            <td>${adminStatus.count}</td>
            <td>${admin.username}</td>
            <td><a href="">Edycja</a></td>
            <td><a href="">Usuń</a></td>
        </tr>
        <br>
    </c:forEach>

</body>
</html>
