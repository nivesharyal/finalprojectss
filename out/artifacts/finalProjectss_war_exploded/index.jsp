<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/29/2022
  Time: 7:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form action="user" method="POST">
    <input type="hidden" name="page" value="LOGIN">
    UserName <input type="text" name="userName" required=""><br>
    Password<input type="password" name="password" required=""><br>
    <input type="submit" value="LOGIN" required="">
    <a href="user?page=newUsers">REGISTER</a>
</form>

</body>
</html>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

<%--    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">--%>

<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>

<%--    <link rel="stylesheet" href="css/style.css">--%>

<%--</head>--%>
<%--<body class="img js-fullheight" style="background-image: url(images/bg.jpg);">--%>
<%--<section class="ftco-section">--%>
<%--    <div class="container">--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-md-6 text-center mb-5">--%>
<%--                <h2 class="heading-section">Student Login</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-md-6 col-lg-4">--%>
<%--                <div class="login-wrap p-0">--%>
<%--                    <h3 class="mb-4 text-center">Have an account?</h3>--%>
<%--                    <form action="user?page=login" method="Post">--%>
<%--                        <div class="form-group">--%>
<%--                            <input type="text" class="form-control" placeholder="Username" name="username" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <input id="password-field" type="password" class="form-control" placeholder="Password" name="password" required>--%>
<%--                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <button type="submit" class="form-control btn btn-primary submit px-3">LOGIN</button>--%>
<%--                        </div>--%>
<%--                        <div class="form-group d-md-flex">--%>
<%--                            <div class="w-50">--%>
<%--                                <label class="checkbox-wrap checkbox-primary">Remember Me--%>
<%--                                    <input type="checkbox" checked>--%>
<%--                                    <span class="checkmark"></span>--%>
<%--                                </label>--%>
<%--                            </div>--%>
<%--                            <div class="w-50 text-md-right">--%>
<%--                                <a href="#" style="color: #fff">Forgot Password</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                    <p class="w-100 text-center">&mdash; Or Don't have an account? &mdash;</p>--%>
<%--                    <div class="social d-flex text-center">--%>

<%--                        <a href="user?page=newUsers" class="px-2 py-2 mr-md-1 rounded"> Register Here </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="js/popper.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<%--<script src="js/main.js"></script>--%>

<%--</body>--%>
<%--</html>--%>