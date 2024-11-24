<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Create Asteroid</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 600px;
      margin: 50px auto;
      background-color: white;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
      text-align: center;
      color: #333;
    }
    label {
      font-size: 1em;
      margin-bottom: 8px;
      display: block;
      color: #333;
    }
    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    a {
      display: block;
      text-align: center;
      margin-top: 20px;
      color: #007BFF;
      text-decoration: none;
    }
    button {
      background-color: #1e2a47;
      color: white;
      border: none;
      padding: 12px 20px;
      cursor: pointer;
      border-radius: 5px;
      width: 100%;
      transition: background-color 0.3s;
    }
    button:hover {
      background-color: #3a4d7c;
    }
    .form-group {
      margin-bottom: 20px;
    }
  </style>
</head>
<body>

<div class="container">
  <h1>Create Asteroid</h1>
  <form action="createAsteroid" method="post">

    <!-- Input Fields for Asteroid -->
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" required>
    </div>

    <div class="form-group">
      <label for="magnitude">Magnitude</label>
      <input type="number" step="any" name="magnitude" id="magnitude" required>
    </div>

    <div class="form-group">
      <label for="diameter">Diameter (km)</label>
      <input type="number" step="any" name="diameter" id="diameter" required>
    </div>

    <div class="form-group">
      <label for="dangerous">Dangerous (Yes/No)</label>
      <input type="checkbox" name="dangerous" id="dangerous">
    </div>

    <!-- Submit Button -->
    <button type="submit">Submit</button>
  </form>
</div>

</body>
</html>
