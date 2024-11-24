<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            font-size: 16px;
            color: #333;
            margin-bottom: 8px;
            display: block;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        input[type="text"]:focus, input[type="password"]:focus {
            border-color: #4CAF50;
            outline: none;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            text-align: center;
            font-size: 16px;
            margin-top: 20px;
        }

        .error-message h1{
            color: red;
        }

        .login-link {
            display: block;
            text-align: center;
            margin-top: 15px;
        }

        .login-link a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }

        .login-link a:hover {
            color: #45a049;
        }

        .form-group {
            margin-bottom: 20px;
            font-family: Arial, sans-serif;
            color: #333;
        }

        .form-group select {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        .form-group select:focus {
            border-color: #007bff;
            outline: none;
        }

        .form-group select:hover {
            border-color: #0056b3;
        }

    </style>
</head>
<body>

<div class="container">
    <h1>Register</h1>
    <form method="post">
        <div>
            <label for="username">Username</label>
            <input type="text" name="username" id="username" required>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required>
        </div>
        <div class="form-group">
            <label for="rol">Role</label>
            <select name="rol" id="rol">
                <option value="astronomer">Astronomer</option>
                <option value="observer">Observer</option>
            </select>
        </div>
        <br>
        <div>
            <button type="submit">Register</button>
        </div>
        <div class="error-message">
            <h1><c:out value="${error}"></c:out></h1>
        </div>
    </form>

    <div class="login-link">
        <p>Already have an account? <a href="login">Login here</a></p>
    </div>
</div>

</body>
</html>
