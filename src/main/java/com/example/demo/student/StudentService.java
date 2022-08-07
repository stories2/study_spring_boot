package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service // injectable
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist) {
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    public void updateNewStudent(Student student) {
        Optional<Student> studentRepo = studentRepository.findById(student.getId());
        if (!studentRepo.isPresent()) {
            throw new IllegalStateException("Student with id " + student.getId() + " does not exists");
        }

        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        studentRepo.get().setDob(student.getDob());
        studentRepo.get().setName(student.getName());
        studentRepo.get().setEmail(student.getEmail());

        studentRepository.save(studentRepo.get());
    }
}
