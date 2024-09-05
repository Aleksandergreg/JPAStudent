package com.example.jpastudent.config;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Bruce");
        s1.setBornDate(LocalDate.of(2010,11,12));
        s1.setBornTime(LocalTime.of(10,11,12));
        studentRepository.save(s1);
        studentRepository.save(s1);
        studentRepository.save(s1);
        studentRepository.save(new Student("Sarah", LocalDate.of(2003, 6, 15), LocalTime.of(8, 23, 45)));
        studentRepository.save(new Student("James Smith", LocalDate.of(2002, 11, 27), LocalTime.of(14, 35, 12)));
        studentRepository.save(new Student("Emily Davis", LocalDate.of(2004, 3, 9), LocalTime.of(7, 12, 30)));
        studentRepository.save(new Student("Michael Brown", LocalDate.of(2003, 8, 22), LocalTime.of(9, 45, 19)));
        studentRepository.save(new Student("Jessica Wilson", LocalDate.of(2001, 12, 1), LocalTime.of(16, 22, 10)));
        studentRepository.save(new Student("Matthew Taylor", LocalDate.of(2002, 4, 14), LocalTime.of(11, 5, 30)));
        studentRepository.save(new Student("Olivia Martinez", LocalDate.of(2004, 7, 18), LocalTime.of(10, 17, 25)));
        studentRepository.save(new Student("Ethan White", LocalDate.of(2003, 9, 30), LocalTime.of(13, 49, 32)));
        studentRepository.save(new Student("Sophia Harris", LocalDate.of(2002, 10, 5), LocalTime.of(15, 33, 21)));
        studentRepository.save(new Student("Daniel Clark", LocalDate.of(2001, 2, 28), LocalTime.of(6, 50, 15)));
        studentRepository.save(new Student("Julius Clark", LocalDate.of(2001, 2, 28), LocalTime.of(6, 50, 15)));



    }
}
