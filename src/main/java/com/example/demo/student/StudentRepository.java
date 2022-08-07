package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// For JPA
// Object type, ID type
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    Select * from student where email = ?;
//    JPQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
