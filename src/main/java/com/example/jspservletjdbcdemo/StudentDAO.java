package com.example.jspservletjdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection con;
    Statement st;

    public int getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Ss@5656056");
            st = con.createStatement();
            return 1;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }

    public int closeConnection(){
        try {
            this.con.close();
            this.st.close();
            return 1;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    public Student getStudent(int UserID){
        Student s = new Student();
        try{
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

    public List<Student> showStudents(){
        List<Student> list = new ArrayList<Student>();

        try{
            ResultSet rs = st.executeQuery("SELECT * FROM student_details");
            while(rs.next()){
                int id = rs.getInt("UserID");
                String name = rs.getString("Name");
                list.add(new Student(id,name));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return list;
    }

    public void addStudent(int id, String name){
        //Student s = new Student(id,name);
        try{
            st.executeUpdate("INSERT INTO student_details VALUES ("+ id + ",'" + name + "')");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
