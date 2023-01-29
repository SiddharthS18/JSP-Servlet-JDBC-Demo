package com.example.jspservletjdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public Student getStudent(int UserID){
        Student s = new Student();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","Ss@5656056");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_details WHERE UserId=" + UserID);
            if(rs.next()){
                s.setUserID(rs.getInt("UserID"));
                s.setName(rs.getString("Name"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return s;
    }
}
