<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>School Students</title>
</head>
<body>
<h1><%= "Welcome to School Database!" %>
</h1>
<br/>
To Get Student -
<form action="GetStudent">
    <input type="text" name="UserID">
    <input type="submit">
</form>
To add Student -
<form action="AddStudent">
    <input type="text" name="UserID">
    <input type="text" name="Name">
    <input type="submit">
</form>
</body>
</html>