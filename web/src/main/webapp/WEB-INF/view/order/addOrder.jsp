<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 05.11.2019
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>form order</title>
</head>
<body>
<form method="post" action="/doOrder" >

    <table border="1" cellpadding="5">
        <input type="hidden" name="carId" value="<c:out value="${car.id}" />" />
        <tr>
            <th>Марка: </th>
            <td>  <c:out value="${car.carName}" />   </td>
        </tr>

        <tr>
            <th>Год выпуска: </th>
            <td> <c:out value="${car.carYear}" />   </td>
        </tr>

        <tr>
            <th>Цвет: </th>
            <td>
                <c:out value="${car.carColor}" />    </td>
        </tr>
        <tr>
            <th>Комментарий: </th>
            <td>                <c:out value="${car.comment}" />    </td>
        </tr>

        <tr>
            <th>Стоимость $, день: </th>
            <td>
                <c:out value="${car.priceDay}" />
                <input type="hidden" name="priceDay" value="<c:out value="${car.priceDay}" />" />
            </td>
        </tr>
        <tr>
            <th>Кол-во дней аренды: </th>
            <td>
                <c:out value="${rentDay}" />
                <input type="hidden" name="rentDay" value="<c:out value="${rentDay}" />" />
            </td>
        </tr>
        <tr>
            <th>Стоимость аренды: </th>
            <td>
                <c:out value="${price}" />
                <input type="hidden" name="price" value="<c:out value="${price}" />" />
            </td>
        </tr>


        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Оформить заказ" />
            </td>
        </tr>

    </table>

</form>
<br>
<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
