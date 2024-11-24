<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies</title>
</head>
<body>
    <h1>Llista de pelis</h1>
    <p>
        <c:forEach var="peli" items='${pelis}'>
            <p><a href="movie?id=${peli.id}">Title: ${peli.title}</a></p>
        </c:forEach>
    </p>
    <a href="createMovie">Crear una pelicula nueva</a>
</body>
</html>
