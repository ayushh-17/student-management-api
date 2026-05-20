package com.example.studentapp.dto;

public class StudentDTO {

    private String name;
    private int marks;

    // GETTERS
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}