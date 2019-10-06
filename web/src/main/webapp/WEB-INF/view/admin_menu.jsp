<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 01.10.2019
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h1>Hello ADMIN!</h1>
<form action="/addPerson" method="post">

    Имя: <input type="text" name="firstName">
    <br>
    Фамилия: <input type="text" name="lastName">
    <br>
    Срок аренды: <input type="number" name="rentDay">дней
    <br><br>
    <input type="submit" value="сделать заявку">

<a href="<c:url value='/addPerson' />">getForm</a>
 <a href="/WEB-INF/view/form.html">получить список</a>
<a href="<c:url value='/logout' />">Logout</a>

</body>
</html>
