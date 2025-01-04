package com.example.pros.controller;

import com.example.pros.model.Attendance;
import com.example.pros.model.Class;
import com.example.pros.repository.AttendanceRepository;
import com.example.pros.repository.ClassRepository;
import com.example.pros.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
public ResponseEntity<?> saveAttendance(@RequestBody List<Attendance> attendanceList) {
    try {
       
        // Use the AttendanceService to handle attendance submission
        attendanceService.submitAttendance(attendanceList);

        return ResponseEntity.ok(attendanceList);
    } catch (Exception e) {
        System.err.println("Error saving attendance: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving attendance: " + e.getMessage());
    }
}

    


    @GetMapping
    public List<Attendance> getAttendance() {
        return attendanceRepository.findAll();
    }


    @PostMapping("/search")
public ResponseEntity<List<Attendance>> searchAttendance(@RequestBody Attendance searchCriteria) {
    try {
        // Parse date from search criteria (if needed)
        String date = searchCriteria.getDate();
 // Assuming 'date' is a string in the format 'yyyy-MM-dd'

        // Step 1: Find classId based on department, year, and session
        String department = searchCriteria.getDepartment();  // Assuming 'department' is passed as part of search criteria
        String year = searchCriteria.getYear();  // Assuming 'year' is passed as part of search criteria
        String session = searchCriteria.getSession();  // Assuming 'session' is passed as part of search criteria
        
        Class classInfo = classRepository.findByDepartmentAndYearAndSession(department, year, session);

        if (classInfo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // No class found
        }

        String classId = classInfo.getId();  // Extract the classId from the found class info

        // Step 2: Fetch attendance records using classId, date, and period
        String period = searchCriteria.getPeriod();  // Get 'period' from search criteria
        List<Attendance> attendanceRecords = attendanceRepository.findAll();
        System.out.println(classId+", "+period+", "+date);  
        System.out.println(attendanceRecords);
        ArrayList<Attendance> result = new ArrayList<>();
for (int i = 0; i < attendanceRecords.size(); i++) {
    if (attendanceRecords.get(i).getClassId().equals(classId.trim()) 
        && attendanceRecords.get(i).getDate().equals(date.trim()) 
        && attendanceRecords.get(i).getPeriod().equals(period.trim())) {
        result.add(attendanceRecords.get(i));
    }
}

System.out.println(result);
        // Step 3: Return the list of attendance records
        return ResponseEntity.ok(result);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Handle any exception
    }
}

    
}
