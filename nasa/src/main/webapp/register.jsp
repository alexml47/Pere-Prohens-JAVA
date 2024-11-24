<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form method="post">
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <label for="rol">Rol</label>
        <input type="text" name="rol" id="rol">
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
    <div>
        <h1><c:out value="${error}"></c:out></h1>
    </div>
</form>
</body>
</html>