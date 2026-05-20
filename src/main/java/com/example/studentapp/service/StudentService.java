package com.example.studentapp.service;

import com.example.studentapp.dto.StudentRequestDTO;
import com.example.studentapp.dto.StudentResponseDTO;
import com.example.studentapp.exception.ResourceNotFoundException;
import com.example.studentapp.exception.StudentNotFoundException;
import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {

        Student s = new Student();
        s.setName(dto.getName());
        s.setMarks(dto.getMarks());

        Student saved = repo.save(s);

        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getMarks()
        );
    }


    // GET ALL
    public List<Student> getAllStudents() {

        return repo.findAll();
    }

    // GET BY ID
    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id)
                );
    }

    // UPDATE
    public Student updateStudent(int id, Student newStudent) {

        Student existing = repo.findById(id).orElse(null);

        if (existing == null) {
            throw new StudentNotFoundException("Student not found with given id");
        }

        existing.setName(newStudent.getName());
        existing.setMarks(newStudent.getMarks());

        return repo.save(existing);
    }


    // DELETE
    public String deleteStudent(int id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Student Deleted";
        }

        return "Student Not Found";
    }
}