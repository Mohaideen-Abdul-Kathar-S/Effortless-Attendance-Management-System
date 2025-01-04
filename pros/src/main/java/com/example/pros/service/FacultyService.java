package com.example.pros.service;

import com.example.pros.model.Faculty;
import com.example.pros.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getFacultyByDepartment(String department) {
        return facultyRepository.findByDepartment(department);
    }

    public Optional<Faculty> getFacultyById(String id) {
        return facultyRepository.findById(id);
    }
}
