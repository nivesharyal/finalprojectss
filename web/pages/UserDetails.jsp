<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2022
  Time: 7:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <td> ${user.id}</td></tr>
    <tr>
        <th>USER-NAME</th>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <th>FULL-NAME</th>
        <td>${user.fullName}</td>
    </tr>
        <th>PASSWORD</th>
        <td>${user.password}</td>
    </tr>

    <a href="user?page=userEdit&id=${user.id}">EDIT</a><br><br>
    <a href="user?page=userDelete&id=${user.id}">DELETE</a>

</table>

</body>
</html>
