package com.example.studenttesting.service;

import java.util.List;

import com.example.studenttesting.model.Student;
import com.example.studenttesting.model.StudentDto;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public StudentDto createStudent(Student student) throws Exception;
    public List<StudentDto> getAllStudent();
    public void deleteStudent(Long id);
    public StudentDto editStudent(Student student);
    public StudentDto getStudentById(Long id);
}
