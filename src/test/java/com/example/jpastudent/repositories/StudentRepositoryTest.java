package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {

    @Autowired
StudentRepository studentRepository;
    @Test
    void findAllByName() {
        List<Student> lst = studentRepository.findAllByName("Sarah");
        assertEquals(1,lst.size());
    }
}