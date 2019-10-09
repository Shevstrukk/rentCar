<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 02.10.2019
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
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
            <th>Actions</th>
        </tr>
        <c:forEach var="person" items="${personList}">
            <tr>
                <td><c:out value="${person.id}" /></td>
                <td><c:out value="${person.firstName}" /></td>
                <td><c:out value="${person.lastName}" /></td>
                <td><c:out value="${person.rentDay}" /></td>
                <td>
                    <form method="post" action="/delete">
                        <input type="number" hidden name="id" value="${person.id}" />
                        <input type="submit" name="delete" value="Удалить"/>
                    </form>
                    <form method="get" action="/update">
                    <input type="number" hidden name="id" value="${person.id}" />
                    <input type="submit" value="Редактированть"/>
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="<c:url value='/newPerson' />">Сделать заявку</a>
<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
