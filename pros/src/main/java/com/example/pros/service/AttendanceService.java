package com.example.pros.service;

import com.example.pros.model.Attendance;
import com.example.pros.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public void submitAttendance(List<Attendance> attendanceData) {
        for (Attendance attendance : attendanceData) {
            // Check if the attendance record exists for the given roll number, class, date, and period
            Attendance existingAttendance = attendanceRepository.findByRollNumberAndClassIdAndDateAndPeriod(
                    attendance.getRollNumber(),
                    attendance.getClassId(),
                    attendance.getDate(),
                    attendance.getPeriod()
            );

            if (existingAttendance != null) {
                // If record exists, update the attendance status
                existingAttendance.setAttendanceStatus(attendance.getAttendanceStatus());
                attendanceRepository.save(existingAttendance); // Save updated record
            } else {
                // If no record exists, create a new record
                attendanceRepository.save(attendance); // Save new record
            }
        }
    }
}

