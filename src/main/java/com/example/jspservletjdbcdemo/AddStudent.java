package com.example.jspservletjdbcdemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddStudent", value = "/AddStudent")
public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userID = Integer.parseInt(request.getParameter("UserID"));
        String name = request.getParameter("Name");

        //Fetch from database
        StudentDAO studentdao = new StudentDAO();
        studentdao.getConnection();
        studentdao.addStudent(userID,name);
        studentdao.closeConnection();

        //Dispatch to jsp to display
        RequestDispatcher rd = request.getRequestDispatcher("studentset.jsp");
        rd.forward(request,response);
    }
}
