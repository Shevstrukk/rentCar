<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>carEntityList</title>
</head>
<body>

<form method="post" action="/saveUpdateCar" >

    <table border="1" cellpadding="5">

        <input type="hidden" name="id" value="<c:out value="${car.id}" />" />

        <tr>
            <th>Марка: </th>
            <td>
                <input type="text" name="carModel" size="45" value="<c:out value="${car.carModel}" />"
                />
            </td>
        </tr>
        <tr>
            <th>Название: </th>
            <td>  <input type="text" name="carName" size="45"   value="<c:out value="${car.carName}" />"  />
            </td>
        </tr>
        <tr>
            <th>Год выпуска: </th>
            <td>
                <input type="number" name="carYear" size="5"  value="<c:out value="${car.carYear}" />"
                />
            </td>
        </tr>
        <tr>
            <th>цвет: </th>
            <td>  <input type="text" name="carColor" size="45"   value="<c:out value="${car.carColor}" />"  />
            </td>
        </tr>
        <tr>
            <th>Топливо: </th>
            <td>  <input type="text" name="carFuel" size="45"   value="<c:out value="${car.carFuel}" />"  />
            </td>
        </tr>
        <tr>
            <th>Стоимость в сутки $: </th>
            <td>
                <input type="number" name="price" size="5"  value="<c:out value="${car.priceDay}" />"
                />
            </td>
        </tr>
        <tr>
            <th>Комментарий: </th>
            <td>
                <input type="text" name="comment" size="5"  value="<c:out value="${car.comment}" />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Обновить" />
            </td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/getCar">Получить машину</a>
<br>

<br>
<a href="${pageContext.request.contextPath}/logout">Выйти</a>

</body>
</html>