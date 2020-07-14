
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
        <h2>Список заказов</h2>
        <caption><h2>List of Orders</h2></caption>

        <c:forEach var="order" items="${personList.orders}">
        <tr>
            <th>id заказа: </th>
            <td>   <td>  <input type="number" name="id" size="45" value="<c:out value="${order.id}" />" />
            </td>
        </tr>
            <c:forEach var="car" items="${order.cars}">
                <tr>
                <th>название машины: </th>
                <td>   <td>  <input type="text" name="carName" size="45" value="<c:out value="${car.carName}" />" />
                </td>
                </tr>

                <tr>
                <th>год выпуска: </th>
                <td>   <td>  <input type="number" name="carYear" size="45" value="<c:out value="${car.carYear}" />" />
                </td>
                </tr>

                <tr>
                <th>цвет машины: </th>
                <td>   <td>  <input type="text" name="carColor" size="45" value="<c:out value="${car.carColor}" />" />
                </td>
                </tr>

                <tr>
                <th>стоимость машины $: </th>
                <td>   <td>  <input type="number" name="carName" size="45" value="<c:out value="${car.priceDay}" />" /> день
                </td>
                </tr>

                <tr>
                <th>комментарий: </th>
                <td>   <td>  <input type="text" name="comment" size="45" value="<c:out value="${car.comment}" />" />
                </td>
                </tr>
            </c:forEach>

                <tr>
                <th>Сумма дней аренды: </th>
                <td>   <td>  <input type="number" name="rentDay" size="45" value="<c:out value="${order.rentDay}" />" /> день
                </td>
                </tr>
                <tr>
                <th>Стоимость заказа: </th>
                <td>   <td>  <input type="number" name="price" size="45" value="<c:out value="${order.price}" />" /> день
                </td>
                </tr>
            <td>
                <form method="post" action="/deleteOrder">
                    <input type="number" hidden name="id" value="${order.id}" />
                    <input type="number" hidden name="personId" value="${personList.id}" />
                    <input type="submit" value="удалить заказ"/>
                </form>
            </td>
        </c:forEach>
        <br>

    </table>

    <br>

</div>
<br>

<a href="/logout">Выйти</a>

<c:if test="${personList.authUser.role == 'admin'}">
    <h3>admin action </h3>
    <a href="/addPersonAuth">Добавить пользователя</a>
</c:if>
<c:if test="${personList.authUser.role == 'user'}">
    <h3> user action </h3>
    <a href="/addOrder">Добавить заказ</a>
</c:if>


</body>
</html>
