<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addPhoneAuth</title>
</head>
<body>
<form method="post" action="/addPhone">
    <tr>
        <th>тел: </th>
        <td>  <input type="number" name="phone" size="5"  />   </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Добавить" />
        </td>
    </tr>
    <c:forEach var="phone" items="${phoneList}">
        <tr>
            <td><c:out value="${phone.line}" /></td>

            <td>
                <form method="post" action="/deletePhone">
                    <input type="number" hidden name="id" value="${phone.id}" />
                    <input type="submit" name="delete" value="Удалить"/>
                </form>
            </td>
            <td>
                <form method="get" action="/updatePhone">
                    <input type="number" hidden name="id" value="${phone.id}" />
                    <input type="submit" value="Редактированть"/>
                </form>

            </td>
        </tr>
    </c:forEach>
</form>
</body>
</html>
