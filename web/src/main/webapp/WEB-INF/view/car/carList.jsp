<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 05.11.2019
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>carList</title>
</head>
<body>
<%--<form method="post" action="/getOrder">--%>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Cars</h2></caption>
        <tr>
            <th>ID</th>
            <th>Марка</th>
            <th>Год</th>
            <th>Цвет</th>
            <th>Стоимость,день</th>
            <th>Комментарий</th>
            <th>Арендовать, дней</th>

        </tr>
        <c:forEach var="cars" items="${carList}">
            <tr>
                <td><c:out value="${cars.id}" /></td>
                <td><c:out value="${cars.carName}" /></td>
                <td><c:out value="${cars.carYear}" /></td>
                <td><c:out value="${cars.carColor}" /></td>
                <td><c:out value="${cars.priceDay}" /></td>
                <td><c:out value="${cars.comment}" /></td>
                <form method="post" action="/getOrder">
                <td> <input type="number" name="rentDay" size="5"  /></td>
                <td>
                    <input type="number" hidden name="id" value="${cars.id}" />
                    <input type="submit" value="Оформить заказ"/>
                </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>
<%--</form>--%>
</body>
</html>
