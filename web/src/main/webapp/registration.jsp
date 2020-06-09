<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h2>Hello Vitalij!</h2>

<form method="post" action="/registration" >

    <table border="1" cellpadding="5">

        <tr>
            <th>Имя: </th>
            <td>
                <input type="text" name="firstName" size="45" />
            </td>
        </tr>
        <tr>
            <th>Фамилия: </th>
            <td>
                <input type="text" name="lastName" size="45" />
            </td>
        </tr>
        <tr>
            <th>Телефон: </th>
            <td>
                <input type="text" name="phone" size="45"  />
            </td>
        </tr>
        <tr>
            <th>Логин: </th>
            <td>
                <input type="text" name="login" size="45"  />
            </td>
        </tr>
        <tr>
            <th>Пароль: </th>
            <td>
                <input type="password" name="password" size="45"  />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Зарегистрироваться" />
            </td>
        </tr>
    </table>
</form>
<a href="<c:url value='/getCars' />">Получить список машин</a>

<a href="<c:url value='/logout' />">Выйти</a>

</body>
</html>