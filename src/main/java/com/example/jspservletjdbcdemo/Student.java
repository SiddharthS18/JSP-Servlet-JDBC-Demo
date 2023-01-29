package com.example.jspservletjdbcdemo;

public class Student{
    private int UserID;
    private String name;

    public Student() {
    }

    public Student(int userID, String name) {
        UserID = userID;
        this.name = name;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "UserID=" + UserID +
                ", name='" + name + '\'' +
                '}';
    }
}
