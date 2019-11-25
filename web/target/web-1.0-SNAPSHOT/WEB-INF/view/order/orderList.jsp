
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

            <c:forEach var="orderEntity" items="${personList.orderEntities}">

        <tr>
                    <td><c:out value="${orderEntity.id}" /></td>
                    <td><c:out value="${orderEntity.rentDay}" /></td>
                    <td><c:out value="${orderEntity.price}" /></td>
                        <c:forEach var="carEntity" items="${orderEntity.carEntities}">

                            <td><c:out value="${carEntity.id}" /></td>
                            <td><c:out value="${carEntity.carName}" /></td>
                            <td><c:out value="${carEntity.priceDay}" /></td>
                            <td><c:out value="${carEntity.comment}" /></td>
                        </c:forEach>


                <td>
                    <form method="post" action="/deleteOrder">
                    <input type="number" hidden name="id" value="${person.id}" />
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
