
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/updateUser" >

    <table border="1" cellpadding="5">

        <input type="hidden" name="id" value="<c:out value="${person.id}" />" />

        <tr>
            <th>Имя: </th>
            <td>
                <input type="text" name="firstName" size="45" value="<c:out value="${person.firstName}" />"
                />
            </td>
        </tr>
        <tr>
            <th>Фамилия: </th>
            <td>  <input type="text" name="lastName" size="45"   value="<c:out value="${person.lastName}" />"  />
            </td>
        </tr>
        <tr>
            <th>Срок аренды: </th>
            <td>
                <input type="number" name="rentDay" size="5"  value="<c:out value="${person.rentDay}" />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Обновить" />
            </td>
        </tr>
    </table>
</form>
<a href="<c:url value='/getPerson' />">Получить список</a>
<br>
<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
