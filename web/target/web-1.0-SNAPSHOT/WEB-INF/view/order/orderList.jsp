
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>orderEntityList</title>
</head>
<body>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Orders</h2></caption>
        <tr>
            <th>id заказа</th>
            <th>Кол-во дней</th>
            <th>стоимость</th>
            <th>id машины</th>
            <th>Название машины</th>
            <th>Стоимость машины, день</th>
            <th>Комментарий</th>
        </tr>

        <c:forEach var="order" items="${personList.orders}">

        <tr>
            <td><c:out value="${order.id}" /></td>
            <td><c:out value="${order.rentDay}" /></td>
            <td><c:out value="${order.price}" /></td>
            <c:forEach var="car" items="${order.cars}">

                <td><c:out value="${car.id}" /></td>
                <td><c:out value="${car.carName}" /></td>
                <td><c:out value="${car.priceDay}" /></td>
                <td><c:out value="${car.comment}" /></td>
            </c:forEach>


            <td>
                <form method="post" action="/deleteOrder">
                    <input type="number" hidden name="id" value="${order.id}" />
                    <input type="number" hidden name="personId" value="${personList.id}" />
                    <input type="submit" value="удалить заказ"/>
                </form>
            </td>
            </c:forEach>
        </tr>
    </table>
</div>
<br>
<a href="<c:url value='/logout' />">Выйти</a>

</body>
</html>
