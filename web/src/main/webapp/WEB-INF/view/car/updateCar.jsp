<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateCar</title>
</head>
<body>
<form method="post" action="/updateCar">
<div align="center">
    <table border="1" cellpadding="5">


            <tr>

            <tr>
                <th>Марка: </th>
                <td> <input type="text" name="carName" size="45" value="<c:out value="${car.carName}" />"    />
                </td>
            </tr>
            <tr>
                <th>Год: </th>
                <td> <input type="number" name="carYear" size="45" value="<c:out value="${car.carYear}" />"    />
                </td>
            </tr>
            <tr>
                <th>Цвет: </th>
                <td> <input type="text" name="carColor" size="45" value="<c:out value="${car.carColor}" />"    />
                </td>
            </tr>
            <tr>
                <th>Стоимость, день: </th>
                <td> <input type="number" name="price" size="45" value="<c:out value="${car.priceDay}" />"    />
                </td>
            </tr>
            <tr>
                <th>Комментарий: </th>
                <td> <input type="text" name="comment" size="45" value="<c:out value="${car.comment}" />"    />
                </td>
            </tr>

                <tr>
                        <td>
                            <input type="number" hidden name="id" value="${car.id}" />
                            <input type="submit" value="обновить"/>
                        </td>

                </tr>
            </tr>
    </table>
</div>
</form>
<br>
<a href="/newPerson">Сделать заявку</a>
<br>

<a href="/logout">logout</a>
</body>
</html>
