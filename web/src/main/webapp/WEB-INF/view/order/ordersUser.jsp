
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>orderUser</title>
</head>
<body>
сделай заказ User
<form method="get" action="/getCarsAuth">
    <input type="submit" value="Получить список машин"/>
</form>

<form method="get" action="/getOrderList">
    <input type="submit" value="Получить список заказов"/>
</form>

<a href="/logout">Выйти</a>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>
