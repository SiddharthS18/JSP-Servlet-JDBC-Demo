<%@ page import="com.example.jspservletjdbcdemo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h1>
    Inside Show Student
</h1>
<%
    Student s = (Student)request.getAttribute("student");
    out.println(s);
%>
</body>
</html>
