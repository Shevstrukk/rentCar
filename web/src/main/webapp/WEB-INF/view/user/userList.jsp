
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>all Persons</title>
</head>
<body>
<center>
    <h1>Person Management</h1>

</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Person</h2></caption>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Аренда(дн)</th>
            <th>Редактировать</th>
        </tr>
        <c:forEach var="person" items="${personList}">
            <tr>
                <td><c:out value="${person.id}" /></td>
                <td><c:out value="${person.firstName}" /></td>
                <td><c:out value="${person.lastName}" /></td>
                <td><c:out value="${person.rentDay}" /></td>

                <td>
                    <form method="get" action="/updateUser">
                        <input type="number" hidden name="id" value="${person.id}" />
                        <input type="submit" value="Редактированть"/>
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="<c:url value='/newUser' />">Сделать заявку</a>
<br>
<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
