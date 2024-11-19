<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nasa</title>
</head>
<body>
<h1>Asteroid</h1>
<p><c:out value="${asteroid.name}"></c:out></p>
<p><c:out value="${asteroid.dangerous}"></c:out></p>
<p><c:out value="${asteroid.diameter}"></c:out></p>
<p><c:out value="${asteroid.magnitude}"></c:out></p>

<form action="aproach" method="post">
    <input type="hidden" name="id" id="id" value="<c:out value="${asteroid.id}"></c:out>">
    <button type="submit">Aproaches</button>
</form>

<form action="editAsteroid" method="get">
    <input type="hidden" name="id" value="<c:out value="${asteroid.id}"></c:out>">
    <button type="submit">Edit</button>
</form>

<form action="delete" method="post">
    <input type="hidden" name="id" value="<c:out value="${asteroid.id}"></c:out>">
    <button type="submit">Delete</button>
</form>
</body>
</html>
