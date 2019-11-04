<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>addPhoneAuth</title>
</head>
<body>
<form method="post" action="/addPhoneAuth">
    <tr>
        <th>тел: </th>
        <td>  <input type="number" name="phone" size="5"  />   </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Добавить" />
        </td>
    </tr>

</form>

    <c:forEach var="phone" items="${phoneList}">
        <tr>
            <td><c:out value="${phone.line}" /></td>

            <td>
                <form method="post" action="/deletePhone">
                    <input type="number" hidden name="id" value="${phone.id}" />
                    <input type="number" hidden name="personId" value="${phone.person.id}">
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
</body>
</html>
