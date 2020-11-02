<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 02.11.2020
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>usuwanie użytkownika</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<form action="/user/delete?id=${user.id}" method="post">

    <table>
        <tr>
            <th>Pole</th>
            <th>Dane użytkownika</th>
        </tr>
        <tr>
            <td>Id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Nazwa użytkownika</td>
            <td>${user.userName}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
    </table>

    <br>
    <strong style="color:red;">Czy na pewno chcesz usunąć tego użytkownika?</strong><br>
    <input type="radio" id="yes" name="choice" value="yes">
    <label for="yes">Tak, na pewno!</label><br>
    <input type="radio" id="no" name="choice" value="no">
    <label for="no">Jednak nie</label><br>

<%--    ${id=user.id}--%>
    <button type="submit">Przekaż decyzję!</button>

</form>

<jsp:include page="footer.jsp"/>

</body>
</html>
