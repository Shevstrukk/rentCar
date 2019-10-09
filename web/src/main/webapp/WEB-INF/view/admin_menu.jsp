<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 01.10.2019
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h2>Hello Vitalij!</h2>

<form method="post" action="/addPerson" >

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
            <th>Срок аренды(дней): </th>
            <td>
                <input type="number" name="rentDay" size="5"  />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Сделать заявку" />
            </td>
        </tr>
    </table>
</form>
<a href="<c:url value='/getPerson' />">Получить список</a>

<a href="<c:url value='/logout' />">Logout</a>

</body>
</html>
