package com.example.pros.controller;


import com.example.pros.model.Class;
import com.example.pros.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassDetailsController {

    @Autowired
    private ClassRepository classDetailsRepository;

    @GetMapping("/api/classes")
    public List<Class> getAllClassDetails() {
        return classDetailsRepository.findAll();
    }
}

