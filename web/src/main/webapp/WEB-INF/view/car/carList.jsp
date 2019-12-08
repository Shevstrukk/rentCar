<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>carEntityList</title>
</head>
<body>

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
        <c:forEach var="carEntities" items="${carEntityList}">
            <tr>
                <td><c:out value="${carEntities.id}" /></td>
                <td><c:out value="${carEntities.carName}" /></td>
                <td><c:out value="${carEntities.carYear}" /></td>
                <td><c:out value="${carEntities.carColor}" /></td>
                <td><c:out value="${carEntities.priceDay}" /></td>
                <td><c:out value="${carEntities.comment}" /></td>
                <form method="post" action="/getOrder">
                    <td> <input type="number" name="rentDay" size="5"  /></td>
                    <td>
                        <input type="number" hidden name="id" value="${carEntities.id}" />
                        <input type="submit" value="Заказать машину"/>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="/logout">Выйти</a>

</body>
</html>
