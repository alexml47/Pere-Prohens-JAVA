<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Asteroid</title>
</head>
<body>
<form action="createAsteroid" method="post">
  <label for="name">Name</label>
  <input type="text" name="name" id="name">

  <label for="magnitude">Magnitude</label>
  <input type="text" name="magnitude" id="magnitude">

  <label for="diameter">Diameter</label>
  <input type="text" name="diameter" id="diameter">

  <label for="dangerous">Dangerous</label>
  <input type="text" name="dangerous" id="dangerous">

  <button type="submit">Submit</button>
</form>
</body>
</html>
