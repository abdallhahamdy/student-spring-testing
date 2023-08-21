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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    @Test
    public void createStudent_thenValidate(){
        studentService = new StudentServiceImpl(studentRepo);

        Student student = createStudent("Abdallha", 24, "01110495598", true);
        Mockito.when(studentRepo.save(student)).thenReturn(createStudentWithID(1L, "Abdallha", 24, "01110495598", true));

        StudentDto studentDto = studentService.createStudent(student);
        Assertions.assertEquals(1, studentDto.getId());
        Assertions.assertEquals("Abdallha", studentDto.getName());
        Assertions.assertEquals(24, studentDto.getAge());
        Assertions.assertEquals("01110495598", studentDto.getPhone());
        Assertions.assertTrue(studentDto.isActive());
    }

    @Test
    public void getAllStudent_thenValidate(){
        studentService = new StudentServiceImpl(studentRepo);
        Mockito.when(studentRepo.findAll()).thenReturn(studentList());
        List<StudentDto> studentListDto = studentService.getAllStudent(); // 0 1 2
        Assertions.assertEquals(5,studentListDto.size());
        StudentDto studentDto = studentListDto.get(2);
        Assertions.assertEquals(3,studentDto.getId());
        Assertions.assertEquals("student3",studentDto.getName());
        Assertions.assertEquals(23, studentDto.getAge());
        Assertions.assertEquals("phone3", studentDto.getPhone());
        Assertions.assertTrue(studentDto.isActive());
    }
    private Student createStudent(String name, int age, String phone, boolean active){
        return new Student(name, age, phone, active);
    }

    private Student createStudentWithID(Long id, String name, int age, String phone, boolean active){
        return new Student(id, name, age, phone, active);
    }

    private List<Student> studentList() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {// 1 2 3 4 5
            students.add(createStudentWithID((long) i, "student" + i, 20 + i, "phone" + i, false));
        }
        return students;
    }
}
