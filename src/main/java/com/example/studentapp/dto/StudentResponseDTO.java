package com.example.studentapp.dto;

public class StudentResponseDTO {

    private int id;
    private String name;
    private int marks;

    public StudentResponseDTO(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}