package com.example.pros.repository;

import com.example.pros.model.Details;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StudentRepository extends MongoRepository<Details, String> {
    List<Details> findByClassId(String classId); // Custom query method
}
