
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>

</head>
<body>

<a href="${pageContext.request.contextPath}/logout">logout</a>

<c:if test="${authUser.role== 'USER'}">
    <h3>Пользователь ${user.firstName}</h3>
    <table>
        <tr>
            <th>Имя</th>
            <th>фамилия</th>
            <th>phone</th>

        </tr>

            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.phone}</td>

            </tr>
        <c:forEach items="${user.orders}" var="order">
            <tr>

                    <td>Аренда${order.rentDay}, дней</td>
                    <td>${order.priceSum}сумма заказа</td>
                    <td>${order.date}дата заказа</td>


            </tr>

        </c:forEach>

    </table>
    <a href="<c:url value="/getCar"/>">Выбрать машину</a>
</c:if>


<c:if test="${authUser.role == 'ADMIN'}">
    <h3>Добавить пользователя</h3>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <table border="1" cellpadding="5">

            <tr>  <th>Имя: </th>     <td>   <input type="text" name="firstName" size="45" />   </td> </tr>

            <tr>  <th>Фамилия: </th> <td>   <input type="text" name="lastName" size="45" />  </td>  </tr>

            <tr>  <th>Телефон: </th> <td>   <input type="text" name="phone" size="45"  />  </td>   </tr>

            <tr>  <th>Логин: </th>  <td>    <input type="text" name="login" size="45"  />  </td>   </tr>

            <tr>
                <th>Пароль: </th>  <td>   <input type="password" name="password" size="45"  />    </td> </tr>
            <tr>  <th>Страна: </th>  <td>   <input type="text" name="country" size="45" />     </td> </tr>

            <tr>
            <th>город: </th>  <td>   <input type="text" name="city" size="45" />     </td>
            </tr>
            <tr>
                <th>улица: </th> <td>  <input type="text" name="street" size="45" />     </td>
            </tr>
            <tr>
                <th>дом: </th>  <td>   <input type="number" name="home" size="5" />     </td>
            </tr>

            <tr>
                <th>номер: </th>  <td>  <input type="number" name="number" size="5"  />   </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Зарегистрировать" />
                </td>
            </tr>
        </table>
    </form>
    <a href="<c:url value="/getCar"/>">Выбрать машину</a>

    <c:if test="${users != null}">
        <table>
            <tr>
                <th>Имя</th>
                <th>фамилия</th>
                <th>phone</th>
                <th>Страна</th>

            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.phone}</td>
                    <td>${user.getAddress().getCountry()  }</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</c:if>

<br>
<a href="<c:url value="/logout"/>">Выйти</a>

</body>
</html>
