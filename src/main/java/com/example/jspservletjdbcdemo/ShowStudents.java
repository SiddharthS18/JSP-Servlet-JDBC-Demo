package com.example.jspservletjdbcdemo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStudents", value = "/ShowStudents")
public class ShowStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Fetch from database
        StudentDAO studentdao = new StudentDAO();
        studentdao.getConnection();
        List<Student> slist = studentdao.showStudents();
        studentdao.closeConnection();

        //Dispatch to jsp to display
        request.setAttribute("studentslist", slist);
        RequestDispatcher rd = request.getRequestDispatcher("showstudents.jsp");
        rd.forward(request,response);
    }
}
