<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 05/11/2024
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <button type="submit">Login</button>
    </div>
    <div>
        <h1><c:out value="${error}"></c:out></h1>
    </div>
</form>
</body>
</html>
