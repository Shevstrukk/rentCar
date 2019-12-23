
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>all Persons</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>
<center>
    <h3>Person Management</h3>

</center>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Person</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Имя</th>--%>
<%--            <th>Фамилия</th>--%>
<%--            <th>город</th>--%>
<%--            <th>улица</th>--%>
<%--            <th>дом</th>--%>
<%--            <th>номер</th>--%>
<%--            <th>телефон</th>--%>
<%--            <th>Удалить</th>--%>
<%--            <th>Редактировать</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="person" items="${personList}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${person.id}" /></td>--%>
<%--                <td><c:out value="${person.firstName}" /></td>--%>
<%--                <td><c:out value="${person.lastName}" /></td>--%>
<%--                <td><c:out value="${person.address.city}" /></td>--%>
<%--                <td><c:out value="${person.address.street}" /></td>--%>
<%--                <td><c:out value="${person.address.home}" /></td>--%>
<%--                <td><c:out value="${person.address.number}" /></td>--%>

<%--                <c:forEach var="phone" items="${person.phones}">--%>
<%--                    <td><c:out value="${phone.line}" /></td>--%>
<%--                </c:forEach>--%>
<%--                <td>--%>
<%--                    <form method="post" action="/delete">--%>
<%--                        <input type="number" hidden name="id" value="${person.id}" />--%>
<%--                        <input type="submit" name="delete" value="Удалить"/>--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <form method="get" action="/update">--%>
<%--                        <input type="number" hidden name="id" value="${person.id}" />--%>
<%--                        <input type="submit" value="Редактированть"/>--%>
<%--                    </form>--%>

<%--                </td>--%>
<%--                <c:forEach var="order" items="${person.orders}">--%>
<%--                    <td><c:out value="${order.id}" /></td>--%>
<%--                    <td><c:out value="${order.rentDay}" /></td>--%>
<%--                    <td><c:out value="${order.price}" /></td>--%>
<%--                </c:forEach>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>

<c:forEach var="person" items="${personList}">
    <div align="center">
    <table border="1" cellpadding="5">
    <tr>
        <th>Имя: </th>
        <td>  <input type="text" name="firstName" size="45" value="<c:out value="${person.firstName}" />" />
        </td>
    </tr>
    <tr>
        <th>Фамилия: </th>
        <td>  <input type="text" name="lastName" size="45"   value="<c:out value="${person.lastName}" />"  /></td>    </tr>
    <tr>
        <th>Область: </th>
        <td>  <input type="text" name="state" size="45"  value="<c:out value="${person.address.state}" />" />    </td>
    </tr><tr>
    <th>город: </th>
        <td>   <input type="text" name="city" size="45"  value="<c:out value="${person.address.city}" />" />
        </td>
    </tr>
    <tr>
        <th>улица: </th>
        <td>    <input type="text" name="street" size="45"  value="<c:out value="${person.address.street}" />"       />   </td>
    </tr>
    <tr>
        <th>дом: </th>
        <td> <input type="number" name="home" size="45"  value="<c:out value="${person.address.home}" />"
        />   </td>
    </tr>

    <tr>
        <th>номер: </th>
        <td>          <input type="number" name="number" size="5"  value="<c:out value="${person.address.number}" />"
        />  </td>
    </tr>

    <c:forEach var="phone" items="${person.phones}">
    <tr>
        <th>тел: </th>
        <td> <input type="number" name="number" size="5"  value="<c:out value="${person.address.number}" />"    /></td>
    </tr>
    </c:forEach>

    <tr>
        <td>id:<c:out value="${person.authUser.id}" />
        <form method="post" action="/delete">
            <input type="number" hidden name="id" value="${person.authUser.id}" />
            <input type="submit"  value="Удалить"/>
        </form>
        </td>

        <td>
            <form method="get" action="/update">
                <input type="number" hidden name="id" value="${person.id}" />
                <input type="submit"  value="Редактировать"/>
            </form>

            <form method="post" action="/getOrderListAuth">
                <input type="number" hidden name="id" value="${person.id}" />
                <input type="submit"  value="Список заказов"/>
            </form>
        </td>
    </tr>
</table>
    </div>
    <br>
</c:forEach>

<nav aria-label="Navigation for countries">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="getPerson?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="getPerson?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="getPerson?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

<br>
<a href="/addPersonAuth">Сделать заявку</a>
<br>

<a href="/logout">logout</a>
</body>
</html>
