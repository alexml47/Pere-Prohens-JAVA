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
    <h1>Llista aproach</h1>
    <ul>
        <c:forEach var="aproach" items='${aproaches}'>
            <li>
                id: ${aproach.id} name: ${aproach.aproachDate}
                <ul>
                    <li>${aproach.velocity}</li>
                    <li>${aproach.distance}</li>
                    <li>${aproach.orbitingBody}</li>
                </ul>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
