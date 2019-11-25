
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
            <th>ROLE</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>город</th>
            <th>улица</th>
            <th>дом</th>
            <th>номер</th>
            <th>телефон</th>
            <th>Удалить</th>
            <th>Редактировать</th>
        </tr>
        <c:forEach var="person" items="${personList}">
            <tr>
                <td><c:out value="${person.id}" /></td>
                <td><c:out value="${person.authUser.role}" /></td>
                <td><c:out value="${person.firstName}" /></td>
                <td><c:out value="${person.lastName}" /></td>
                <td><c:out value="${person.address.city}" /></td>
                <td><c:out value="${person.address.street}" /></td>
                <td><c:out value="${person.address.home}" /></td>
                <td><c:out value="${person.address.number}" /></td>

                <c:forEach var="phone" items="${person.phones}">
                    <%--                    <td><c:out value="${phoneEntity.id}" /></td>--%>
                    <td><c:out value="${phone.line}" /></td>
                </c:forEach>
                <td>
                    <form method="post" action="/delete">
                        <input type="number" hidden name="id" value="${person.authUser.id}" />
                        <input type="submit" name="delete" value="Удалить"/>
                    </form>
                </td>
                <td>
                    <form method="get" action="/update">
                        <input type="number" hidden name="id" value="${person.id}" />
                        <input type="submit" value="Редактированть"/>
                    </form>

                </td>
                <c:forEach var="order" items="${person.orders}">
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.rentDay}" /></td>
                    <td><c:out value="${order.price}" /></td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="<c:url value='/newPerson' />">Сделать заявку</a>
<br>
<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
