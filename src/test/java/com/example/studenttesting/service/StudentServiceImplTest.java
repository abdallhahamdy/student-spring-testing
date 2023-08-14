package com.example.studenttesting.service;

import com.example.studenttesting.Repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    @Test
    public void test() {

    }
}
