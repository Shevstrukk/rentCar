<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newPerson</title>
</head>
<body>
<form method="post" action="/newPerson" >

    <table border="1" cellpadding="5">

        <tr>
            <th>Имя: </th>
            <td>
                <input type="text" name="firstName" size="45"  />
            </td>
        </tr>
        <tr>
            <th>Фамилия: </th>
            <td>  <input type="text" name="lastName" size="45"  />
            </td>
        </tr>
        <tr>
            <th>Срок аренды: </th>
            <td>
                <input type="number" name="rentDay" size="5"   />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Добавить" />
            </td>
        </tr>
    </table>
</form>
<a href="<c:url value='/getPerson' />">Получить список</a>
</body>
</html>