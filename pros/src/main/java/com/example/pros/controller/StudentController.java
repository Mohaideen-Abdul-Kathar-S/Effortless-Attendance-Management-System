package com.example.pros.controller;

import com.example.pros.model.Details;
import com.example.pros.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Endpoint to get students by classId
    @GetMapping("/class/{classId}")
    public List<Details> getStudentsByClassId(@PathVariable String classId) {
        return studentRepository.findByClassId(classId);
    }
}
