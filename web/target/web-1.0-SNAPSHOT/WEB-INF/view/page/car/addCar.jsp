<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addCar</title>

</head>
<body>

<a href="${pageContext.request.contextPath}/logout">logout</a>


<c:if test="${authUser.role == 'ADMIN'}">
    <h3>Добавить машину</h3>
    <form action="${pageContext.request.contextPath}/addCar" method="post">
        <table border="1" cellpadding="5">

            <tr>  <th>Марка: </th>     <td>   <input type="text" name="carModel" size="20" />   </td> </tr>

            <tr>  <th>Название: </th> <td>   <input type="text" name="carName" size="20" />  </td>  </tr>

            <tr>  <th>год выпуска: </th> <td>   <input type="number" name="carYear" size="20"  />  </td>   </tr>

            <tr>  <th>Цвет: </th>  <td>    <input type="text" name="carColor" size="20"  />  </td>   </tr>

            <tr>  <th>Топливо: </th>  <td>   <input type="text" name="carFuel" size="20"  />    </td> </tr>

            <tr>  <th>Стоимость сутки: </th>  <td>   <input type="number" name="price" size="5" />   </td> </tr>

            <tr>  <th>Комментарий: </th>  <td>   <input type="text" name="comment" size="45" />     </td>    </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="добавить" />
                </td>
            </tr>

        </table>
    </form>
    <a href="<c:url value="/getCar"/>">Выбрать машину</a>


</c:if>
<br>
<a href="<c:url value="/logout"/>">Выйти</a>

</body>
</html>

