package com.example.studenttesting.service;

import com.example.studenttesting.model.Student;
import com.example.studenttesting.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentDto createStudent(Student student) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public StudentDto editStudent(Student student) {
        return null;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return null;
    }
}
