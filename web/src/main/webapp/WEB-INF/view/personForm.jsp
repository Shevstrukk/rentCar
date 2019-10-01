<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 02.10.2019
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person Store Application</title>
</head>
<body>
<center>
    <h1>Persons Management</h1>
    <h2>
        <a href="/new">Add New Person</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Persons</a>

    </h2>
</center>
<div align="center">
    <c:if test="${person != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${person == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${person != null}">
                            Edit Person
                        </c:if>
                        <c:if test="${person == null}">
                            Add New Person
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${person != null}">
                    <input type="hidden" name="id" value="<c:out value='${person.id}' />" />
                </c:if>
                <tr>
                    <th>Имя: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${person.firstName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Фамилия: </th>
                    <td>
                        <input type="text" name="author" size="45"
                               value="<c:out value='${person.lastName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Срок аренды: </th>
                    <td>
                        <input type="text" name="price" size="5"
                               value="<c:out value='${person.rentDay}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
