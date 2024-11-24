<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nasa Approaches</title>
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
        ul {
            padding-left: 20px;
        }
        li {
            margin-bottom: 15px;
        }
        .approach-item {
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        a {
            background-color: #1e2a47;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            display: block;
            text-align: center;
            margin-top: 10px;
            transition: background-color 0.3s;
            text-decoration: none;
        }
        a:hover {
            background-color: #3a4d7c; /* Darker background on hover */
        }
        .approach-item strong {
            color: #1e2a47;
        }
        .no-approaches {
            font-style: italic;
            color: #777;
        }
        .approach-item ul {
            margin-top: 10px;
            list-style-type: none;
            padding: 0;
        }
        .approach-item ul li {
            padding: 5px 0;
        }
    </style>
</head>
<body>

<header>
    <h1>List of Approaches</h1>
</header>

<div class="container">
    <c:if test="${empty aproaches}">
        <p class="no-approaches">No approaches found for this asteroid.</p>
    </c:if>

    <c:forEach var="aproach" items="${aproaches}">
        <div class="approach-item">
            <p><strong>Date:</strong> ${aproach.aproachDate}</p>
            <ul>
                <li><strong>Velocity:</strong> ${aproach.velocity}</li>
                <li><strong>Distance:</strong> ${aproach.distance}</li>
                <li><strong>Orbiting Body:</strong> ${aproach.orbitingBody}</li>
            </ul>
        </div>
    </c:forEach>

    <!-- Create Approach Link -->
    <c:choose>
        <c:when test="${sessionScope.Astronomer == true}">
            <a href="createAproach?id=${asteroid}">Create Approach</a>
        </c:when>

        <c:otherwise>
        </c:otherwise>
    </c:choose>

    <!-- Return Link -->
    <a href="asteroid?id=${asteroid}">Return</a>
</div>

</body>
</html>
