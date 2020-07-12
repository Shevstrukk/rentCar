<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>carEntityList</title>
</head>
<body>
<c:if test="${authUser.role == 'ADMIN'}">
    <a href="${pageContext.request.contextPath}/addCar">Добавить машину</a>
</c:if>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Cars</h2></caption>
        <tr>
            <th>ID</th>
            <th>Марка</th>
            <th>Название</th>
            <th>Год</th>
            <th>Цвет</th>
            <th>вид топлива</th>
            <th>стоимость $ в сутки</th>
            <th>Комментарий</th>


        </tr>
        <c:forEach var="carEntities" items="${carEntityList}">
            <tr>
                <td><c:out value="${carEntities.id}" /></td>
                <td><c:out value="${carEntities.carModel}" /></td>
                <td><c:out value="${carEntities.carName}" /></td>
                <td><c:out value="${carEntities.carYear}" /></td>
                <td><c:out value="${carEntities.carColor}" /></td>
                <td><c:out value="${carEntities.carFuel}" /></td>
                <td><c:out value="${carEntities.priceDay}" /></td>
                <td><c:out value="${carEntities.comment}" /></td>
                <form method="post" action="/getOrder">
                <td>
                    <label for="localdate">арендовать с: </label>
                    <input type="datetime-local" id="localdate" name="dateStart"/>
                </td>
                <td>
                    <label for="localdate">до: </label>
                    <input type="datetime-local" id="date" name="dateEnd"/>
                </td>

                    <td>
                        <input type="number" hidden name="carId" value="${carEntities.id}" />
                        <input type="submit" value="Заказать машину"/>
                    </td>
                </form>
                <c:if test="${authUser.role == 'ADMIN'}">
                <td>
                    <form method="post" action="/deleteCar">
                        <input type="number" hidden name="id" value="${carEntities.id}" />
                        <input type="submit" name="id" value="Удалить"/>
                    </form>
                </td>
                    <td>
                        <form method="post" action="/updateCar">
                            <input type="number" hidden name="id" value="${carEntities.id}" />
                            <input type="submit" name="id" value="Обновить"/>
                        </form>
                    </td>

                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>