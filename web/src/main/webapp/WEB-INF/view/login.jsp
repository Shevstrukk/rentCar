
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>



<h1>Вход в систему</h1><br>
<form method="post" action="/login">

    <input type="text" required placeholder="login" name="login"><br>
    <input type="password" required placeholder="password" name="password"><br><br>
    <input type="submit" value="Войти">

</form>

<a href="regisration">Зарегистрироваться</a>
<p style="color: red">${error}</p>
</body>
</html>
