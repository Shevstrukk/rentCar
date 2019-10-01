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
    <h2>
        <a href="/new">Add New Book</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Books</a>

    </h2>
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
        <c:forEach var="person" items="${listPerson}">
            <tr>
                <td><c:out value="${person.id}" /></td>
                <td><c:out value="${person.firstName}" /></td>
                <td><c:out value="${person.lastName}" /></td>
                <td><c:out value="${person.rentDay}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${person.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${person.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
