<%@ page import="java.util.Objects" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../../static/forms.css">
</head>
<!--<div class="container">
    <h2>Login</h2>

    <form action="/authenticate" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <% if (Objects.equals(request.getParameter("error"), "username")) { %>
        <p>Username doesn't exist</p>
        <% } %>
        <% if (Objects.equals(request.getParameter("error"), "password")) { %>
        <p>Password is incorrect</p>
        <% } %><br/>
    </form>-->
<div class="container">
    <h2>Admin Login</h2>

    <form action="/adminAuthenticate" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <% if (Objects.equals(request.getParameter("error"), "username")) { %>
        <p>Username is incorrect</p>
        <% } %>
        <% if (Objects.equals(request.getParameter("error"), "password")) { %>
        <p>Password is incorrect</p>
        <% } %>
        <br/>
        <input type="submit" value="Login">
    </form>
</div>


</div>
</body>
</html>