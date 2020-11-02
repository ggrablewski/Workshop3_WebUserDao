<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 01.11.2020
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lista użytkowników</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h2>Lista użytkowników</h2><br>

<table>
    <tr>
        <th>Lp.</th>
        <th>Nazwa użytkownika</th>
        <th>Email</th>
        <th>Akcje</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>
                <a href="/user/edit?id=${user.id}">Edytuj</a>
                <p> / </p>
                <a href="/user/show?id=${user.id}">Pokaż</a>
                <p> / </p>
                <a href="/user/delete?id=${user.id}">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer.jsp"/>

</body>
</html>
