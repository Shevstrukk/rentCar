
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post" action="/update" >

    <table border="1" cellpadding="5">

        <input type="hidden" name="id" value="<c:out value="${person.id}" />" />
        <input type="hidden" name="idAuth" value="<c:out value="${person.authUser.id}" />" />
        <input type="hidden" name="login" value="<c:out value="${person.authUser.login}" />" />
        <input type="hidden" name="password" value="<c:out value="${person.authUser.password}" />" />
        <input type="hidden" name="role" value="<c:out value="${person.authUser.role}" />" />
        <input type="hidden" name="addressId" value="<c:out value="${person.address.id}" />" />

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
            <th>город: </th>
            <td>
                <input type="text" name="city" size="45"  value="<c:out value="${person.address.city}" />"
                />
            </td>
        </tr>
        <tr>
            <th>улица: </th>
            <td>
                <input type="text" name="street" size="45"  value="<c:out value="${person.address.street}" />"       />
            </td>
        </tr>
        <tr>
            <th>дом: </th>
            <td>
                <input type="number" name="home" size="45"  value="<c:out value="${person.address.home}" />"
                />
            </td>
        </tr>
        <tr>
            <th>номер: </th>
            <td>
                <input type="number" name="number" size="5"  value="<c:out value="${person.address.number}" />"
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

<a href="/getPerson">Получить список</a>
<br>
<a href="/logout">Выйти</a>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>
