<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 7/1/19
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rentals</title>
</head>
<body>

    <h1>All rentals</h1>
    <c:forEach items="${rentals}" var="rental" varStatus="rentalStatus">
        <tr>
            <td>${rentalStatus.count}</td>
            <td>${rental.hirePlace.name}</td>
            <td>${rental.hireDate}</td>
            <td>${rental.returnPlace.name}</td>
            <td>${rental.returnDate}</td>
            <td><a href="">Edycja</a></td>
            <td><a href="">Usuń</a></td>
        </tr>
        <br>
    </c:forEach>



</body>
</html>
