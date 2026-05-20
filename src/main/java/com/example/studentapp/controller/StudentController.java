package com.example.studentapp.controller;

import com.example.studentapp.dto.StudentRequestDTO;
import com.example.studentapp.dto.StudentResponseDTO;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.studentapp.response.ApiResponse;

import java.util.List;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> addStudent(
            @Valid @RequestBody StudentRequestDTO dto
    ) {
        StudentResponseDTO savedStudent = service.addStudent(dto);

        ApiResponse<StudentResponseDTO> response =
                new ApiResponse<>("Student added successfully", 200, savedStudent);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {

        List<Student> students = service.getAllStudents();

        ApiResponse<List<Student>> response =
                new ApiResponse<>("Students fetched successfully", 200, students);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable int id) {

        Student student = service.getStudentById(id);

        ApiResponse<Student> response =
                new ApiResponse<>("Student fetched successfully", 200, student);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable int id,
            @RequestBody Student s
    ) {

        Student updatedStudent = service.updateStudent(id, s);

        ApiResponse<Student> response =
                new ApiResponse<>(
                        "Student updated successfully",
                        200,
                        updatedStudent
                );

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable int id) {

        String result = service.deleteStudent(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        result,
                        200,
                        null
                );

        return ResponseEntity.ok(response);
    }
}