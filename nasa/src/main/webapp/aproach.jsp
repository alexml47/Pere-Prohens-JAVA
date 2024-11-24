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
</head>
<body>
<h1>List of Approaches</h1>

<!-- Check if the list is empty -->
<c:if test="${empty aproaches}">
    <p>No approaches found for this asteroid.</p>
</c:if>

<!-- Loop through the 'aproaches' list -->
<c:forEach var="aproach" items="${aproaches}">
    <li>
        <strong>Date:</strong> ${aproach.aproachDate} <br>
        <ul>
            <li><strong>Velocity:</strong> ${aproach.velocity}</li>
            <li><strong>Distance:</strong> ${aproach.distance}</li>
            <li><strong>Orbiting Body:</strong> ${aproach.orbitingBody}</li>
        </ul>
    </li>
</c:forEach>

</body>
</html>