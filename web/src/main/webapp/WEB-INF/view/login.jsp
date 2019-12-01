
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>



    <h1>Вход в систему</h1><br>
    <form method="POST" action="/login">

        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br><br>
        <input class="button" type="submit" value="Войти">

    </form>

<a href="<c:url value='/regisration' />">Зарегистрироваться</a>
<p style="color: red">${error}</p>
</body>
</html>
