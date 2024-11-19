// FacultyRepository.java
package com.example.pros.repository;

import com.example.pros.model.Faculty;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends MongoRepository<Faculty, String> {
    List<Faculty> findByDepartment(String department);
    Optional<Faculty> findById(String id);
}
