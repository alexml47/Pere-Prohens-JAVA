<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Movie</title>
  </head>
  <body>
    <p>Title: <c:out value="${peli.title}"></c:out></p>
    <p>Description: <c:out value="${peli.description}"></c:out></p>
    <p>Year: <c:out value="${peli.year}"></c:out></p>
    <br>
    <a href="editMovie?id=${peli.id}"><p>Editar los detalles</p></a>
    <form action="deleteMovie" method="post">
      <input type="hidden" value="${peli.id}" name="id" id="id">
      <button type="submit"><p>Borrar la pelicula</p></button>
    </form>
    <a href="movies">Ir atras</a>
  </body>
</html>
