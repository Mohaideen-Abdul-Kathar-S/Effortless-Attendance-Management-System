// WorkRepository.java
package com.example.pros.repository;

import com.example.pros.model.Work;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface WorkRepository extends MongoRepository<Work, String> {
    List<Work> findByFacultyId(String facultyId);
}



