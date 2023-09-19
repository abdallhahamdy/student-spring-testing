package com.example.studenttesting.controller;

import java.util.List;

import com.example.studenttesting.model.Student;
import com.example.studenttesting.model.StudentDto;
import com.example.studenttesting.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student) throws Exception {
        return ResponseEntity.ok(studentService.createStudent(student));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/edit")
    public ResponseEntity<StudentDto> editStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.editStudent(student));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
}