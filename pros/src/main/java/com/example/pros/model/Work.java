// Work.java
package com.example.pros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "works")
public class Work {
    @Id
    private String id;
    private String department;
    private String year;
    private String session;
    private String period;
    private String day;
    private String facultyId;
    private String classId;

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session = session;
    }

    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getFacultyId() {
        return facultyId;
    }
    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getclassId() {
        return classId;
    }
    public void setclassId(String classId) {
        this.classId = classId;
    }
}
