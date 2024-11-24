<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Edit Asteroid</title>
    <style>
        /* General styles for the page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Styling the form container */
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        /* Style for each input label */
        label {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 8px;
            display: block;
            color: #333;
        }

        /* Style for each input field */
        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        /* Style for the submit button */
        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        /* Hover effect for the submit button */
        button[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Style for hidden inputs */
        input[type="hidden"] {
            display: none;
        }

        /* Optional: Style for error messages */
        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h1>Edit Asteroid</h1>

    <!-- Start of the form -->
    <form action="editAsteroid" method="post">
        <!-- Hidden input for the asteroid ID -->
        <input type="hidden" name="id" id="id" value="<c:out value='${asteroid.id}'/>">
        <input type="hidden" name="nasaAsteroid" id="nasaAsteroid" value="<c:out value='${asteroid.nasaAsteroid}'/>">

        <!-- Name field -->
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="<c:out value='${asteroid.name}'/>">

        <!-- Magnitude field -->
        <label for="magnitude">Magnitude</label>
        <input type="number" step="any" name="magnitude" id="magnitude" value="<c:out value='${asteroid.magnitude}'/>">

        <!-- Diameter field -->
        <label for="diameter">Diameter</label>
        <input type="number" step="any" name="diameter" id="diameter" value="<c:out value='${asteroid.diameter}'/>">

        <!-- Dangerous field -->
        <div class="form-group">
            <label for="dangerous">Dangerous (Yes/No)</label>
            <input type="checkbox" name="dangerous" id="dangerous"
                    <c:if test="${asteroid.dangerous}">
                        checked
                    </c:if> />
        </div>

        <!-- Submit button -->
        <button type="submit">Submit</button>
    </form>

    <!-- Optional: Display error messages if any -->
    <div class="error-message">
        <!-- Display any error messages here -->
    </div>
</div>

</body>
</html>
