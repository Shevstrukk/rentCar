
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>addCar</title>
</head>
<body>
<h3>Добавить машину </h3>
<form action="${pageContext.request.contextPath}/addCar" method="post">
    <label for="carName">Название машины</label>
    <input id="carName" type="text" name="carName"><br/>

    <label for="carYear">Год выпуска</label>
    <input id="carYear" type="number" name="carYear"><br/>

    <label for="carColor">цвет</label>
    <input id="carColor" type="text" name="carColor"><br/>

    <label for="price">стоимость</label>
    <input id="price" type="number" name="price"><br/>

    <label for="comment">комментарий</label>
    <input id="comment" type="text" name="comment"><br/>

    <input type="submit" value="добавить машину">
</form>
<br>

<div align="center">
    <table border="1" cellpadding="5">

        <c:forEach var="carEntities" items="${carEntityList}">
            <tr>
                <tr>
                    <th>id: </th>
                    <td> <input type="number" name="id" size="45" value="<c:out value="${carEntities.id}" />"    />
                    </td>
                </tr>
                <tr>
                    <th>Марка: </th>
                    <td> <input type="text" name="carName" size="45" value="<c:out value="${carEntities.carName}" />"    />
                    </td>
                </tr>
                <tr>
                    <th>Год: </th>
                    <td> <input type="number" name="carYear" size="45" value="<c:out value="${carEntities.carYear}" />"    />
                    </td>
                </tr>
            <tr>
                <th>Цвет: </th>
                <td> <input type="text" name="carColor" size="45" value="<c:out value="${carEntities.carColor}" />"    />
                </td>
            </tr>
            <tr>
                <th>Стоимость, день: </th>
                <td> <input type="number" name="price" size="45" value="<c:out value="${carEntities.priceDay}" />"    />
                </td>
            </tr>
            <tr>
                <th>Комментарий: </th>
                <td> <input type="text" name="comment" size="45" value="<c:out value="${carEntities.comment}" />"    />
                </td>
            </tr>


                <tr>
                <form method="post" action="/deleteCar">
                    <td>
                        <input type="number" hidden name="id" value="${carEntities.id}" />
                        <input type="submit" value="удалить машину"/>
                    </td>
                </form>


                <form method="get" action="/updateCar">
                    <td>
                        <input type="number" hidden name="id" value="${carEntities.id}" />
                        <input type="submit" value="обновить"/>
                    </td>
                </form>
                </tr>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="/addPersonAuth">Сделать заявку</a>
<br>

<a href="/logout">logout</a>
</body>
</html>
