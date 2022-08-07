package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student stories2 = new Student(
                    1L,
                    "stories2",
                    "stories2@gapmoe.net",
                    LocalDate.of(2000, Month.JULY, 5)
            );

            Student hazimenya = new Student(
                    "hazimenya",
                    "hazimenya@gapmoe.net",
                    LocalDate.of(2022, Month.AUGUST, 21)
            );

            studentRepository.saveAll(
                    List.of(stories2, hazimenya)
            );
        };
    }
}
