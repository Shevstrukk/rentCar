
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
</head>
<body>

<h2>Hello Vitalij!</h2>

<form method="post" action="/addUser" >

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
                <input type="submit" value="Зарегистрировать" />
            </td>
        </tr>

    </table>

</form>


<form action="/getPerson">

    <input type="hidden" name="currentPage" value="1">

    <div class="form-group col-md-4">

        <label for="records">Кол-во записей на странице:</label>

        <select class="form-control" id="records" name="recordsPerPage">
            <option value="3">3</option>
            <option value="6" selected>6</option>
            <option value="15">15</option>
        </select>

    </div>

    <button type="submit" class="btn btn-primary"> Получить список personof</button>

</form>

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" ></script>

<a href="${pageContext.request.contextPath}/addCar">Получить список машин</a>
<h6>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</h6>
</body>
</html>
