package com.RKexample.springbootredis.service;

import com.RKexample.springbootredis.model.Student;
import com.RKexample.springbootredis.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

@NoArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

   public Optional<Student> getStudentById(String id){
        return studentRepository.findById(id);
   }

   public Student createStudent(Student student){
        return studentRepository.save(student);
   }

   public Optional<Student> updateStudent(String id,Student student){
        return studentRepository.findById(id).map(existingStudent ->{
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            return studentRepository.save(existingStudent);
        } );
   }

   public void deleteStudent(String id){
        studentRepository.deleteById(id);
   }
}
