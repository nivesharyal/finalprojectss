<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/30/2022
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="ftco-section">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <h3 class="mb-4 text-center">Update users details</h3>
                    <form action="user?page=updateUser" method="Post">
                        <input type="hidden" name="id" value="${user.id}">
                        <div class="form-group">

                            <input type="text" class="form-control" value="${user.userName}" placeholder="Username" name="userName" required>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" value="${user.fullName}" placeholder="Full name" name="fullName" required>
                        </div>
                        <div class="form-group">
                            <input id="password-field" type="password" value="${user.password}" class="form-control" placeholder="Password" name="password"
                                   required>
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary submit px-3">Update user</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
