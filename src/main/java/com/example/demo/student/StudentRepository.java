package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// For JPA
// Object type, ID type
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
