package com.example.jspservletjdbcdemo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetStudent", value = "/GetStudent")
public class GetStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int userID = Integer.parseInt(request.getParameter("UserID"));
        StudentDAO studentdao = new StudentDAO();
        Student s = studentdao.getStudent(userID);

        request.setAttribute("student", s);
        RequestDispatcher rd = request.getRequestDispatcher("showstudent.jsp");
        rd.forward(request,response);
    }

}
