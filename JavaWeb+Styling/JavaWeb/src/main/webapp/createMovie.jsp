<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 31/10/2024
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Movie</title>
</head>
<body>
    <form action="createMovie" method="get">
        <div class="rendered-form">
            <div class="formbuilder-text form-group field-text-1730378765321">
                <label for="title" class="formbuilder-text-label">Title<span class="formbuilder-required">*</span></label>
                <input type="text" placeholder="Back to future..." class="form-control" name="title" id="title" required="required" aria-required="true">
            </div>
            <div class="formbuilder-text form-group field-text-1730378768038">
                <label for="description" class="formbuilder-text-label">Description<span class="formbuilder-required">*</span></label>
                <textarea type="textarea" placeholder="A great movie about..." class="form-control" name="description" id="description" required="required" aria-required="true"></textarea>
            </div>
            <div class="formbuilder-text form-group field-text-1730378768228">
                <label for="year" class="formbuilder-text-label">Year<span class="formbuilder-required">*</span></label>
                <input type="text" placeholder="1997" class="form-control" name="year" id="year" required="required" aria-required="true">
            </div>
        </div>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
