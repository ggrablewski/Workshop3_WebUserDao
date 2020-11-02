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
    <title>edycja użytkownika</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h3>Edycja użytkownika</h3><br>

<form action="/user/edit?id=${currUser.id}" method="post">
    <table>
        <tr>
            <th>Pole</th>
            <th>Obecna wartość</th>
            <th>Nowa wartość</th>
        </tr>
        <tr>
            <td>Id</td>
            <td>${currUser.id}</td>
            <td>${currUser.id}</td>
        </tr>
        <tr>
            <td>Nazwa użytkownika</td>
            <td>Jest: ${currUser.userName}</td>
            <label>Zmień na:
                <input type="text" name="userName" placeholder="wymyśl oryginalną :-)">
            </label>
        </tr>
        <tr>
            <td>Email</td>
            <td>Jest: ${currUser.email}</td>
            <label>Zmień na:
                <input type="text" name="email" placeholder="email@server">
            </label>
        </tr>
        <tr>
            <td>Hasło</td>
            <td>************</td>
            <label>Zmień na:
                <input type="password" name="password" placeholder="użyj: DUŻE, małe, specjalne">
            </label>
        </tr>

    </table>
<%--    ${id=currUser.id}--%>
    <button type="submit">Zmień!</button>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>
