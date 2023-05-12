<%--
Created by IntelliJ IDEA.
User: TRY
Date: 2023/3/30
Time: 2:28
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <form action="person" method="post" class="form">
        <h2>Login Form</h2>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" id="pwd" name="pwd" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="button" onclick="window.location.assign('register/register.html')" class="btn btn-secondary">Register</button>
        </div>
    </form>
</div>
<button onclick="window.location.href='employeeLogin.jsp'">Employee Login</button>
<script src="index.js"></script>
</body>
</html>