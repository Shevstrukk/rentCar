<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>addPhone</title>
</head>
<body>
<form method="post" action="/addPhone">
    <tr>
        <th>тел: </th>
        <td>  <input type="number" name="phoneEntity" size="5"  />   </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Добавить" />
        </td>
    </tr>

</form>

<c:forEach var="phoneEntity" items="${phoneList}">
    <tr>
        <td><c:out value="${phoneEntity.line}" /></td>

        <td>
            <form method="post" action="/deletePhone">
                <input type="number" hidden name="id" value="${phoneEntity.id}" />

                <input type="submit" name="delete" value="Удалить"/>
            </form>
        </td>

    </tr>
</c:forEach>
<a href="<c:url value='/getCars' />">Получить список машин</a>
<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
