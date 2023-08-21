package com.example.studenttesting.service;

import com.example.studenttesting.Repo.StudentRepo;
import com.example.studenttesting.model.Student;
import com.example.studenttesting.model.StudentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    @Test
    public void createStudent_thenValidate(){
        studentService = new StudentServiceImpl(studentRepo);
        Student student = createStudent();
        Mockito.when(studentRepo.save(student)).thenReturn(createStudentWithID());

        StudentDto studentDto = studentService.createStudent(student);
        Assertions.assertEquals(1, studentDto.getId());
        Assertions.assertEquals("Abdallha", studentDto.getName());
        Assertions.assertEquals(24, studentDto.getAge());
        Assertions.assertEquals("01110495598", studentDto.getPhone());
        Assertions.assertTrue(studentDto.isActive());
    }

    private Student createStudent(){
        return new Student("Abdallha", 24, "01110495598", true);
    }

    private Student createStudentWithID(){
        return new Student(1,"Abdallha", 24, "01110495598", true);
    }

}
