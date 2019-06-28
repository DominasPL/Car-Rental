<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/28/19
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

    <h1>All users</h1>
    <c:forEach items="${users}" var="user" varStatus="userStatus">
        <tr>
            <td>${userStatus.count}</td>
            <td>${user.username}</td>
            <%--<td><a href="/admin/panel/admins/edit/${admin.id}">Edycja</a></td>--%>
            <%--<td><a href="/admin/panel/admins/delete/${admin.id}">Usuń</a></td>--%>
        </tr>
    </c:forEach>


</body>
</html>
