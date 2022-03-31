<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/30/2022
  Time: 7:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="/include/navBar.jsp"%>
</head>
<body>
<a href="user?page=newUsers">AddUser</a>
<table class="table table-dark">

<thead>
<tr>
    <th scope="col">ID</th>
    <th scope="col">userName</th>
    <th scope="col">fullName</th>
    <th scope="col">password</th>
    <th scope="col">action</th>
</tr>
</thead>
<c:forEach items="${arrayList}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.fullName}</td>
        <td>${user.password}</td>

       <td> <a href="user?page=UserDetails&id=${user.id}">User Details</a></td>

    </tr>
</c:forEach>

</table>

</body>
</html>
