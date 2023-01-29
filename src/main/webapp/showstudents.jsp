<%@ page import="com.example.jspservletjdbcdemo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    List<Student> list = (List<Student>)request.getAttribute("studentslist");
    out.println(Arrays.toString(list.toArray()));
  %>
</body>
</html>
