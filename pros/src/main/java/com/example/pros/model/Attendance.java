package com.example.pros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "attendance")
public class Attendance {
    @Id
    private String id;  // MongoDB document ID
    private String rollNumber;
    private String name;
    private String attendanceStatus;
    private String classId;
    private String department;
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String facultyId;
    private String date;
    private String day;
    private String year;
    private String session;
    private String period;
    /*
     rollNumber,
                    name,
                    attendanceStatus: attendanceMap[rollNumber],
                    classId,
                    facultyId,
                    period,
                    date,
                    day
    */

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session = session;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getClassId() {
      return classId;
  }

  public void setClassId(String classId) {
      this.classId = classId;
  }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

   
}
