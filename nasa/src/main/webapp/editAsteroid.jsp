<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 19/11/2024
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Asteroid</title>
</head>
<body>
<form action="editAsteroid" method="post">
    <input type="hidden" name="id" id="id" <c:out value="${asteroid.id}"></c:out>>
    <label for="name">Name</label>
    <input type="text" name="name" id="name" <c:out value="${asteroid.name}"></c:out>>

    <label for="magnitude">Magnitude</label>
    <input type="text" name="magnitude" id="magnitude" <c:out value="${asteroid.magnitude}"></c:out>>

    <label for="diameter">Diameter</label>
    <input type="text" name="diameter" id="diameter" <c:out value="${asteroid.diameter}"></c:out>>

    <label for="dangerous">Dangerous</label>
    <input type="text" name="dangerous" id="dangerous" <c:out value="${asteroid.dangerous}"></c:out>>

    <button type="submit">Submit</button>
</form>
</body>
</html>
