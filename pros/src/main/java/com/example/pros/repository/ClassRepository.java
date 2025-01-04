
package com.example.pros.repository;

import com.example.pros.model.Class;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ClassRepository extends MongoRepository<Class, String> {
    List<Class> findByDepartment(String department);

    Class findByDepartmentAndYearAndSession(String department, String year, String session);

}
