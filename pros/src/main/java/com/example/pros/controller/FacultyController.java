// FacultyController.java
package com.example.pros.controller;

import java.util.HashMap;
import java.util.Map;
import com.example.pros.model.Faculty;
import com.example.pros.model.Work;
import com.example.pros.repository.FacultyRepository;
import com.example.pros.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin // Add this if you encounter CORS issues when testing locally
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private WorkRepository workRepository;

    // Add a new faculty member
    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Get a list of all faculty members by department
    @GetMapping
    public List<Faculty> getFacultyByDepartment(@RequestParam String department) {
        return facultyRepository.findByDepartment(department);
    }

    // Get a specific faculty member by ID
    @GetMapping("/{id}")
    public Optional<Faculty> getFacultyById(@PathVariable String id) {
        return facultyRepository.findById(id);
    }

    // Delete a faculty member by ID
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable String id) {
        facultyRepository.deleteById(id);
    }

    // Add a new work entry for a specific faculty member
    @PostMapping("/{id}/works")
public Work addWorkToFaculty(@PathVariable String id, @RequestBody Work work) {
    try {
        work.setFacultyId(id);
        return workRepository.save(work);
    } catch (Exception e) {
        e.printStackTrace();  // Log the error to get more insight
        throw new RuntimeException("Error saving work details: " + e.getMessage());
    }
}


    // Get all works for a specific faculty member by faculty ID
    @GetMapping("/{id}/works")
    public List<Work> getWorksByFacultyId(@PathVariable String id) {
        return workRepository.findByFacultyId(id);
    }

    @DeleteMapping("/{facultyId}/works/{workId}")
public ResponseEntity<String> deleteWork(@PathVariable String facultyId, @PathVariable String workId) {
    try {
        Optional<Work> work = workRepository.findById(workId);
        if (work.isPresent() && work.get().getFacultyId().equals(facultyId)) {
            workRepository.deleteById(workId);
            return ResponseEntity.ok("Work details deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Work not found for the faculty ID.");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting work details: " + e.getMessage());
    }
}

    @PostMapping("/faculty/login")
public ResponseEntity<Map<String, Boolean>> verifyLogin(@RequestBody Map<String, String> credentials) {
    String id = credentials.get("id");
    String password = credentials.get("password");

    Optional<Faculty> faculty = facultyRepository.findById(id);
    Map<String, Boolean> response = new HashMap<>();
    
    if (faculty.isPresent() && faculty.get().getPassword().equals(password)) {
        response.put("verified", true);
        return ResponseEntity.ok(response);
    } else {
        response.put("verified", false);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
}
