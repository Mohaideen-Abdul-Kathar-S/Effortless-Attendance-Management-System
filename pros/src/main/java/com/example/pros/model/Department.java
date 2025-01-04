package com.example.pros.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "departments")
public class Department {
    
    @Id
    private String id;
    private List<String> dept = new ArrayList<>(); // Initialize to avoid null pointer issues

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDept() {
        return dept;
    }

    public void setDept(List<String> dept) {
        this.dept = dept;
    }
}
