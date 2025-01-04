package com.example.pros.controller;

import com.example.pros.model.Department;
import com.example.pros.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get departments
    @GetMapping
    public List<String> getDepartments() {
        Department deptData = departmentRepository.findAll().stream().findFirst().orElse(new Department());
        return deptData.getDept();
    }

    // Add department
    @PostMapping("/add")
    public String addDepartment(@RequestBody String newDept) {
        Department deptData = departmentRepository.findAll().stream().findFirst().orElse(new Department());
        List<String> departments = deptData.getDept();
        if (departments != null && !departments.contains(newDept)) {
            departments.add(newDept);
        } else if (departments == null) {
            deptData.setDept(List.of(newDept));
        }
        departmentRepository.save(deptData);
        return "Department added";
    }

    // Delete department
    @DeleteMapping("/delete/{deptName}")
    public String deleteDepartment(@PathVariable String deptName) {
        Department deptData = departmentRepository.findAll().stream().findFirst().orElse(null);
        if (deptData != null && deptData.getDept().contains(deptName)) {
            deptData.getDept().remove(deptName);
            departmentRepository.save(deptData);
            return "Department deleted";
        }
        return "Department not found";
    }
}
