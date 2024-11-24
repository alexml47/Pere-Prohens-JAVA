<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nasa - Asteroids</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .form-container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .form-container form {
            margin: 0;
        }

        .button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }

        .button:hover {
            background-color: #45a049;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            background-color: #fff;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        li a {
            font-size: 18px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        li a:hover {
            color: #4CAF50;
        }

        ul li ul {
            margin-top: 10px;
            padding-left: 20px;
            color: #555;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Synchronize and Edit buttons -->
    <div class="form-container">
        <form action="synchronize" method="post">
            <button class="button" type="submit">Synchronize</button>
        </form>

        <form action="edit" method="post">
            <input type="hidden" name="_method" value="patch">
            <!-- Edit functionality can be implemented here if needed -->
        </form>
    </div>

    <!-- Create Asteroid Link -->
    <a href="createAsteroid" class="button">Create Asteroid</a>

    <h1>List of Asteroids</h1>

    <!-- Asteroids List -->
    <ul>
        <c:forEach var="asteroid" items="${asteroids}">
            <li>
                <a href="asteroid?id=${asteroid.id}">Name: ${asteroid.name}</a>
                <ul>
                    <li><strong>Diameter:</strong> ${asteroid.diameter}</li>
                    <li><strong>Diameter:</strong> ${asteroid.magnitude}</li>
                    <li><strong>Dangerous:</strong> ${asteroid.dangerous}</li>
                </ul>
            </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>
