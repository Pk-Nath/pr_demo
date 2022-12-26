package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping()
    public ResponseEntity<StudentDto> createOneStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteOneStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
        return "data deleted";
    }
}
