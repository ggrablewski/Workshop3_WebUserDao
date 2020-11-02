<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 02.11.2020
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>wyświetlanie użytkownika</title>
</head>
<body>

<jsp:include page="header.jsp"/>

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

<button type="submit">Dziękuję!</button>

<jsp:include page="footer.jsp"/>

</body>
</html>
