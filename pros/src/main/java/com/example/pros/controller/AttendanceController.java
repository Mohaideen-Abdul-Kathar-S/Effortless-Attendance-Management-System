package com.example.pros.controller;

import com.example.pros.model.Attendance;
import com.example.pros.repository.AttendanceRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping
    public String saveAttendance(@RequestBody List<Attendance> attendanceList) {
        attendanceRepository.saveAll(attendanceList);
        return "Attendance saved successfully";
    }

    @GetMapping
    public List<Attendance> getAttendance() {
        return attendanceRepository.findAll();
    }


    
    @PostMapping("/search")
    public List<Attendance> searchAttendance(@RequestBody Attendance searchCriteria) {
        LocalDate date = LocalDate.parse(searchCriteria.getDate().toString());  // Assuming 'date' is in LocalDate format
        
        // Assuming you want to filter by classId (department), date, period, and other fields
        return attendanceRepository.findByClassIdAndDateAndPeriod(
                searchCriteria.getClassId(),    // Department or ClassId
                date,                           // Date
                searchCriteria.getPeriod()      // Period
        );
    }
}
