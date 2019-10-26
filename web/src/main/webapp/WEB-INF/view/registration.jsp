<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 26.10.2019
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<div class="form">

    <h1>Вход в систему</h1><br>
    <form method="post" action="/regisration">

        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Зарегистрироваться">

    </form>
</div>
<a href="<c:url value="/logout"/>">Выйти</a>
<p style="color: red">${error}</p>
</body>
</html>
