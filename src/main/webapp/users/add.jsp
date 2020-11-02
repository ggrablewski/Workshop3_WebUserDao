<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 02.11.2020
  Time: 00:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dodawanie użytkownika</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h3>Dodawanie użytkownika</h3><br>

<form action="/user/add" method="post">
    <label>Nazwa użytkownika
        <input type="text" name="userName" placeholder="wymyśl oryginalną :-)">
    </label>
    <label>Email
        <input type="text" name="email" placeholder="email@server">
    </label>
    <label>Hasło
        <input type="password" name="password" placeholder="użyj: DUŻE, małe, specjalne">
    </label>
    <button type="submit">Dodaj!</button>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>
