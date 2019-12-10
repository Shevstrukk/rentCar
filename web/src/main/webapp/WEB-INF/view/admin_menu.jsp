
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h2>Hello Vitalij!</h2>

<form method="post" action="/addPersonAuth" >



    <table border="1" cellpadding="5">

        <tr>
            <th>Имя: </th>
            <td>   <input type="text" name="firstName" size="45" />     </td>
        </tr>
        <tr>
            <th>Фамилия: </th>
            <td>     <input type="text" name="lastName" size="45" />       </td>    </tr>
        <tr>
            <th>Область: </th>
            <td>   <input type="text" name="state" size="45" />     </td>
        </tr><tr>
        <th>город: </th>
        <td>   <input type="text" name="city" size="45" />     </td>
    </tr>
        <tr>
            <th>улица: </th>
            <td>   <input type="text" name="street" size="45" />     </td>
        </tr>
        <tr>
            <th>дом: </th>
            <td>   <input type="number" name="home" size="5" />     </td>
        </tr>

        <tr>
            <th>номер: </th>
            <td>         <input type="number" name="number" size="5"  />   </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Зарегистрироваться" />
            </td>
        </tr>

    </table>

</form>
<a href="${pageContext.request.contextPath}/getPerson">Получить список</a>
<a href="${pageContext.request.contextPath}/addCar">Получить список машин</a>
<%--<a href="<c:url value="/getPerson' />">Получить список</a>--%>


<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>
