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
<form action="synchronize" method="post">
    <button>Synchronize</button>
</form>
<h1>Llista asteroids</h1>
<ul>
    <c:forEach var="asteroid" items='${asteroids}'>
        <li>
            id: ${asteroid.id} name: ${asteroid.name}
            <ul>
                <li>${asteroid.dangerous}</li>
                <li>${asteroid.diameter}</li>
                <li>${asteroid.id}</li>
            </ul>
        </li>
    </c:forEach>
</ul>
</body>
</html>