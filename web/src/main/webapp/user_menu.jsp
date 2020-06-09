<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 01.10.2019
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>

</head>
<body>

<a href="${pageContext.request.contextPath}/logout">logout</a>

<c:if test="${authUser.role== 'USER'}">
    <h3>Пользователь</h3>
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

    </table>
</c:if>


<c:if test="${authUser.role == 'ADMIN'}">
    <h3>Добавить пользователя</h3>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <label for="firstName">имя</label>
        <input id="firstName" type="text" name="firstName"><br/>

        <label for="lastName">фамилия</label>
        <input id="lastName" type="text" name="lastName"><br/>

        <label for="phone">phone</label>
        <input id="phone" type="text" name="phone"><br/>

        <input type="submit">
    </form>
    <c:if test="${users != null}">
        <table>
            <tr>
                <th>Имя</th>
                <th>фамилия</th>
                <th>phone</th>

            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.phone}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>
</c:if>

<br>
<a href="<c:url value="/logout"/>">Выйти</a>

</body>
</html>
