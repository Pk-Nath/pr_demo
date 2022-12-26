package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student=mapToEntity(studentDto);
        Student save = studentRepository.save(student);
        StudentDto dto=mapToDto(save);
        return dto;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> all = studentRepository.findAll();
        List<StudentDto> collect = all.stream().map(student -> mapToDto(student)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).get();
        return mapToDto(student);
    }

    @Override
    public void deleteStudentById(long id) {
        System.err.println(id);
        studentRepository.deleteById(id);
    }

    private StudentDto mapToDto(Student save) {
        StudentDto dto=new StudentDto();
        dto.setRollNo(save.getRollNo());
        dto.setFirstName(save.getFirstName());
        dto.setLastName(save.getLastName());
        return dto;
    }

    private Student mapToEntity(StudentDto studentDto) {
        Student stud=new Student();
        stud.setFirstName(studentDto.getFirstName());
        stud.setLastName(studentDto.getLastName());
        return stud;
    }
}
