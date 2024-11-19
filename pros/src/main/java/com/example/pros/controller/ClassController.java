
// StudentController.java
package com.example.pros.controller;

import com.example.pros.model.Class;
import com.example.pros.model.Details;
import com.example.pros.repository.ClassRepository;
import com.example.pros.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/class")
@CrossOrigin // Add this if you encounter CORS issues when testing locally
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    // Add a new faculty member
    @PostMapping
    public Class addClass(@RequestBody Class classroom) {
        return classRepository.save(classroom);
    }

    @GetMapping("/all")
public List<Class> getAllClasses() {
    return classRepository.findAll();
}
    // Get a list of all faculty members by department
    @GetMapping
    public List<Class> getClassByDepartment(@RequestParam String department) {
        return classRepository.findByDepartment(department);
    }

    // Get a specific faculty member by ID
    @GetMapping("/{id}")
    public Optional<Class> getClassById(@PathVariable String id) {
        return classRepository.findById(id);
    }

    // Delete a faculty member by ID
    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable String id) {
        classRepository.deleteById(id);
    }

    // Add a new work entry for a specific faculty member
    @PostMapping("/{id}/details")
public Details addDetailsToClass(@PathVariable String id, @RequestBody Details details) {
    try {
        details.setClassId(id);
        return detailsRepository.save(details);
    } catch (Exception e) {
        e.printStackTrace();  // Log the error to get more insight
        throw new RuntimeException("Error saving Student Details : " + e.getMessage());
    }
}


    // Get all works for a specific faculty member by faculty ID
    @GetMapping("/{id}/details")
    public List<Details> getDetailsByClassId(@PathVariable String id) {
        return detailsRepository.findByClassId(id);
    }

     @DeleteMapping("/{id}/details/{rollNumber}")
    public ResponseEntity<String> deleteDetailsByRollNumber(@PathVariable String id, @PathVariable String rollNumber) {
        try {
            Details details = detailsRepository.findByClassIdAndRollNumber(id, rollNumber);
            if (details != null) {
                detailsRepository.delete(details);
                return ResponseEntity.ok("Student details deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting student details: " + e.getMessage());
        }
    }
}

