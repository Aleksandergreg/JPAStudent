package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        var obj = studentRepository.findAll();
        return obj;
    }

    @GetMapping("/addstudent")
    public List<Student> addstudent() {
        Student std = new Student();
        std.setName("Johnny");

        studentRepository.save(std);
        return List.of(std);


    }

    @GetMapping("students/{name}")
    public ResponseEntity<List> getallstudentsbyname(@PathVariable String name) {

        List<Student> studentsList = studentRepository.findAllByName(name);
        if (!studentsList.isEmpty()){
            return ResponseEntity.ok(studentsList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
  @GetMapping("studentsID/{id}")
    public ResponseEntity<Student> getallstudentsbyname1(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()){
            return ResponseEntity.ok(orgStudent.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(student.getId());
        if (orgStudent.isPresent()) {
            studentRepository.save(student);
            return ResponseEntity.ok(student);
            //return new ResponseEntity<>(student,HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");

        }
    }
}