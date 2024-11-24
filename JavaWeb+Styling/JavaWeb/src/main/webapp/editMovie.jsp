<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 31/10/2024
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Movie</title>
</head>
<body>
<form action="editMovie" method="get">
    <div class="rendered-form">
        <input type="hidden" name="id" id="hidden" value="<c:out value="${peliID}"></c:out>">
        <div class="formbuilder-text form-group field-text-1730378765321">
            <label for="title" class="formbuilder-text-label">Title<span class="formbuilder-required">*</span></label>
            <input type="text" value="<c:out value="${peliEdit.title}"></c:out>" class="form-control" name="title" id="title" required="required" aria-required="true">
        </div>
        <div class="formbuilder-text form-group field-text-1730378768038">
            <label for="description" class="formbuilder-text-label">Description<span class="formbuilder-required">*</span></label>
            <textarea type="textarea" class="form-control" name="description" id="description" required="required" aria-required="true"><c:out value="${peliEdit.description}"></c:out></textarea>
        </div>
        <div class="formbuilder-text form-group field-text-1730378768228">
            <label for="year" class="formbuilder-text-label">Year<span class="formbuilder-required">*</span></label>
            <input type="text" value="<c:out value="${peliEdit.year}"></c:out>" class="form-control" name="year" id="year" required="required" aria-required="true">
        </div>
    </div>
    <button type="submit">Submit</button>
</form>
</body>
</html>
