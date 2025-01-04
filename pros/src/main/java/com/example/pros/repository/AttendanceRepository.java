package com.example.pros.repository;


import java.util.List;

import com.example.pros.model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    // Query to find a specific attendance record based on roll number, class, date, and period
    Attendance findByRollNumberAndClassIdAndDateAndPeriod(String rollNumber, String classId, String date, String period);

    // Query to find all attendance records for a specific class and date
    List<Attendance> findByClassIdAndDateAndPeriod(String classId, LocalDate date, String period);

    List<Attendance> findByClassIdAndDateAndPeriodAndYearAndSession(String classId, LocalDate date, String period, String year, String session);
}
