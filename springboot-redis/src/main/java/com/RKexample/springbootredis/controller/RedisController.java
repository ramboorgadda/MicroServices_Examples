package com.RKexample.springbootredis.controller;

import com.RKexample.springbootredis.model.Student;
import com.RKexample.springbootredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class RedisController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/get/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }
    @PostMapping("/create")
    public Student createStudent( @RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PostMapping("/update/{id}")
    public Optional<Student> updateStudent( @PathVariable String id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

}
