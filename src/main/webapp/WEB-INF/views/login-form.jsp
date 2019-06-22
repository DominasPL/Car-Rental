<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dominik
  Date: 6/22/19
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>There is a login form</h1>
    <form class="form-container" method="post" action="/login">
        <c:if test="${param.error!=null}">
            <span>Nieprawidłowe dane logowania!</span> <br>
        </c:if>
        <c:if test="${param.logout != null}">
            <span>Zostałeś wylogowany!</span> <br>
        </c:if>
        <div class="form-group">
            <label>Nazwa użytkownika:</label>
            <input type="text" class="form-control" name="username" required min="3" max="20" aria-describedby="emailHelp" placeholder="Podaj nazwe użytkownika">
        </div>
        <div class="form-group">
            <label>Hasło</label>
            <input type="password" class="form-control" name="password" required min="3" max="20" placeholder="Podaj hasło">
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" name="remember-me">
            <label class="form-check-label">Zapamiętaj</label>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Potwierdź</button>
    </form>

</body>
</html>
