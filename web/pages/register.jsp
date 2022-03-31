<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/29/2022
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user?page=register" method="POST">
    UserName<input type="text" name="userName" required=""><br>
    FullName<input type="text" name="fullName" required=""><br>
    Password<input type="password" name="password" required=""><br>
    <input type="submit" value="register" required="">
<%--    <a href="user?page=index">Login</a>--%>
    <a href="user?page=oldUsers">Login</a>
</form>

</body>
</html>
