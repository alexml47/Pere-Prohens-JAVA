<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nasa</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #1e2a47;
            color: white;
            text-align: center;
            padding: 20px;
        }
        h1 {
            font-size: 2em;
            margin: 0;
        }
        .container {
            max-width: 900px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .asteroid-info p {
            font-size: 1.2em;
            margin: 10px 0;
        }
        .asteroid-info strong {
            color: #1e2a47;
        }
        form, a {
            margin-bottom: 10px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        button, a {
            background-color: #1e2a47;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
            text-align: center;
            text-decoration: none;
        }
        button:hover, a:hover {
            background-color: #3a4d7c;
        }
        a {
            display: block;
        }
    </style>
</head>
<body>

<header>
    <h1>Asteroid Details</h1>
</header>

<div class="container">
    <div class="asteroid-info">
        <p><strong>Name:</strong> <c:out value="${asteroid.name}"></c:out></p>
        <p><strong>Dangerous:</strong> <c:out value="${asteroid.dangerous}"></c:out></p>
        <p><strong>Diameter:</strong> <c:out value="${asteroid.diameter}"></c:out> km</p>
        <p><strong>Magnitude:</strong> <c:out value="${asteroid.magnitude}"></c:out></p>
    </div>

    <!-- Approaches link -->
    <a href="aproach?id=${asteroid.id}">Approaches</a>

    <c:choose>
        <c:when test="${sessionScope.Astronomer == true}">
            <!-- Edit link -->
            <a href="editAsteroid?id=${asteroid.id}">Edit</a>

            <!-- Delete Button -->
            <form action="delete" method="post">
                <input type="hidden" name="id" value="${asteroid.id}">
                <button type="submit">Delete</button>
            </form>
        </c:when>

        <c:otherwise>
        </c:otherwise>
    </c:choose>

    <!-- Return link -->
    <a href="asteroids">Return</a>
</div>

</body>
</html>
