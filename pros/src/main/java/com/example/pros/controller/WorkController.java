package com.example.pros.controller;

import com.example.pros.model.Work;
import com.example.pros.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    @Autowired
    private WorkRepository workRepository;

    @GetMapping("/options")
    public List<Work> getUniqueDepartmentYearClassOptions() {
        List<Work> allWorks = workRepository.findAll();
        return allWorks.stream()
                .distinct() // Ensure unique combinations
                .collect(Collectors.toList());
    }

    @GetMapping("/faculty/{id}")
    public List<Work> getWorksByFaculty(@PathVariable String id) {
        // Directly fetch data from the repository
        return workRepository.findByFacultyId(id);
    }


    @GetMapping("/{id}")
    public Work getWorkById(@PathVariable String id) {
        return workRepository.findById(id).orElseThrow(() -> new RuntimeException("Work not found"));
    }
}

