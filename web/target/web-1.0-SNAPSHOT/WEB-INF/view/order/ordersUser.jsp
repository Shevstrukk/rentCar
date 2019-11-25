
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>orderUser</title>
</head>
<body>
сделай заказ User
<form method="get" action="/getCars">
    <input type="submit" value="Получить список машин"/>
</form>

<form method="get" action="/getOrderList">
    <input type="submit" value="Получить список заказов"/>
</form>

<a href="<c:url value='/logout' />">Выйти</a>
</body>
</html>
